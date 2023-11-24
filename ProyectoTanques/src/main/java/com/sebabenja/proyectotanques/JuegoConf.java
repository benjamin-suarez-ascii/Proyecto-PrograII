/*e
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebabenja.proyectotanques;


import java.util.LinkedList;
//setea colores
import java.awt.Color;


//trabaja con dimensiones
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//modifica el panel de la pnatalla.
import javax.swing.JPanel;
// aqui se configura la pantalla.



public class JuegoConf extends JPanel {
    final int tamCasilla = 16;
    final int P_ancho = 640;
    final int  P_alto = 480;
    private static final String ARCHIVO = "puntuaciones.bin";
    static int disparosRealizadosp1 = 0;
    static int disparosRealizadosp2 = 0;
    static int disparosRecibidosp1 = 0;
    static int disparosRecibidosp2 = 0;
    
    //controles
    KeyHandler KeyH = new KeyHandler();
    
    //fotogramas por segundo        
    int FPS = 60;
    
    //se crea el hilo del cicloProgra
    Thread CicloProgra;
    
    int contador = 0;
    
    
    LinkedList<Balas> Abalas = new LinkedList<>();
    LinkedList<ObjTanque> tank = new LinkedList<>();
    
    
    public JuegoConf(){
        //setea el tamaño
        this.setPreferredSize(new Dimension(P_ancho,P_alto));
        //color de fondo
        this.setBackground(Color.black);
        //toca investigar 
        this.setDoubleBuffered(true);
        
        //hace que el panel pueda leer las teclas
        this.addKeyListener(KeyH);
        this.setFocusable(true);
    }
    
    //función para inicar el juego
    public void IniciarCiclo(){
        CicloProgra = new Thread(this.CicloProgra);
        CicloProgra.start();
        Iniciar();
    }
   
    public void Iniciar(){
        //procesos del programa  
        
        //nanosegundos por fotograma
        double IntervaloPorDibujo = 1000000000/FPS; //si
        
        //los nanoseugndos a tiempo real
        double sigDibu = System.nanoTime() + IntervaloPorDibujo;
        
        GameLoad();
        ///por mientras el hilo este activo
        while (CicloProgra != null){
            //System.out.println("se esta ejectuando");
            
            //procesos de actualizacion
            GameUpdate();
            
            //con esto se puede llamar al meotodo paintComponent  
            repaint();
        
            try {
                
                //lo que sobra brothers
                double TiempoRestante = sigDibu - System.nanoTime();
                
                // ya no cacho muchacho, pero se vuelve a dividir
                TiempoRestante = TiempoRestante/1000000;
                
                if(TiempoRestante < 0){
                    
                    TiempoRestante = 0;
                }
                Thread.sleep((long)TiempoRestante);
                sigDibu += IntervaloPorDibujo;
                
            }catch (InterruptedException e){
               //por si facha muchacho
                e.printStackTrace();
                
            }
        }
    }
   
    //cargar elementos del juego(Graficos, variables, etc...)
    public void GameLoad(){
        System.out.println("Cargando");
        tank.add( new ObjTanque(1,1,1,1));
        tank.add(new ObjTanque(2,600,450,180));
        
    } 
    
    //EL APDEIT
    public void GameUpdate(){
        
        //se llama al metodo moverse del player 1
        
    	try {
    		for (ObjTanque A : tank) {
    			
    			A.Moverse(KeyH);
    			switch(A.id) {
    			case 1:
    				A.ColiTank(tank.get(1));
    				if (KeyH.J1_shoot){
    					A.Disparar();
    				}
    				if (A.RecibirDaño(tank.get(1))){
    					A.vida -= 1;
    					disparosRealizadosp1 += 1;
    					
    				}
    			break;
    			case 2: 
    				A.ColiTank(tank.get(0));
    				if (KeyH.J2_shoot){
    					A.Disparar();
    				}
    				if (A.RecibirDaño(tank.get(0))){
    					A.vida -= 1;
    					disparosRealizadosp2 += 1;
    				}
    					break;
    			
    			
    			}
    		if (A.vida <= 0) {
    			tank.remove(A);
    			escribirPuntuacion();
    		}
    		}}catch(Exception E) {}
    	
    	
        
        
        
    }
    
    //dibuja las cosas para el juego
    @Override
    
    //metodo de awt que sirve para dibujar graficos
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        //ete sech 
        Graphics2D g2 = (Graphics2D)g;
        
        //metodo dibujar del jugador
        for (ObjTanque A : tank)
        {
        	A.Dibujar(g2);
        	 g2.setColor(Color.white);
        	switch(A.id){
        	case 1: g2.drawString(""+A.vida, 0, 470); break;
        	case 2: g2.drawString(""+A.vida, 600, 470); break;
        	}
        	
        }
        
        	//player2.Dibujar(g2);
        
        

        //L de Luigi
       
       
        g2.dispose();
    }
    
    private static void escribirPuntuacion() throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(ARCHIVO, true))) {
        	out.writeInt(disparosRealizadosp1);
            out.writeInt(disparosRecibidosp1);
            out.writeInt(disparosRealizadosp2);
            out.writeInt(disparosRecibidosp2);
        }
    }

}
