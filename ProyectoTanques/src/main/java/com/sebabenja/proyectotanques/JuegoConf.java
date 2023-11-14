/*e
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebabenja.proyectotanques;

//setea colores
import java.awt.Color;
//trabaja con dimensiones
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
//modifica el panel de la pnatalla.
import javax.swing.JPanel;
// aqui se configura la pantalla.



public class JuegoConf extends JPanel {
    final int tamCasilla = 16;
    final int P_ancho = 640;
    final int  P_alto = 480;
    
    //controles
    KeyHandler KeyH = new KeyHandler();
    
    //fotogramas por segundo        
    int FPS = 60;
    
    //se crea el hilo del cicloProgra
    Thread CicloProgra;
    
    int contador = 0;
    int hsp = 0;
    int vsp = 0;
    int dir1 = 1;
    int dir2 = 1;
    ObjTanque player1 = new ObjTanque(45,35,1);
   
    
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
        
    } 
    
    //EL APDEIT
    public void GameUpdate(){
        
        //se llama al metodo moverse del player 1
        player1.Moverse(KeyH);
        
        
        //para que la L de luigi rebote
        if (this.vsp >= this.getSize().getHeight()-160){
            this.dir2 = -1;
        }else if (this.vsp < 0) {
            this.dir2 = 1;
            }
        
        if (this.hsp >= this.getSize().getWidth()-192){
            this.dir1 = -1;
        }else if (this.hsp < 0) {
            this.dir1 = 1;
            }
        
        
        this.hsp += this.dir1;
        this.vsp += this.dir2;
       
        
        
    }
    
    //dibuja las cosas para el juego
    @Override
    
    //metodo de awt que sirve para dibujar graficos
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        //ete sech 
        Graphics2D g2 = (Graphics2D)g;
        
        //metodo dibujar del jugador
        player1.Dibujar(g);
        
        //L de Luigi
        g2.setColor(Color.white);
        g2.fillRect(32+this.hsp,0+this.vsp,128,32);
        g2.fillRect(0+this.hsp,32+this.vsp,192,96);
        g2.fillRect(32+this.hsp,128+this.vsp,128,32);
        //dibuja un rectangulo (auque dibuje una L)
        g2.setColor(Color.green);
        g2.fillRect(64+this.hsp,32+this.vsp,32,96);
        g2.fillRect(96+this.hsp,96+this.vsp,32,32);
        //ahora pequeña
        g2.setColor(Color.white);
        g2.fillRect(2,0,8,2);
        g2.fillRect(0,2,12,6);
        g2.fillRect(2,8,8,2);
        //dibuja un rectangulo (auque dibuje una L)
        g2.setColor(Color.green);
        g2.fillRect(4,2,2,6);
        g2.fillRect(6,6,2,2);
        g2.dispose();
    }
    
}
