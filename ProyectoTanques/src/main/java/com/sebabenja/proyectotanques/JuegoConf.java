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
    final int P_ancho = 480;
    final int  P_alto = 320;
    
    int hsp = 0;
    int vsp = 0;
    int dir1 = 1;
    int dir2 = 1;
            
    int FPS = 60;
    
    Thread CicloProgra;
    
    public JuegoConf(){
        //setea el tamaño
        this.setPreferredSize(new Dimension(P_ancho,P_alto));
        //color de fondo
        this.setBackground(Color.black);
        //toca investigar 
        this.setDoubleBuffered(true);
    }

    public void IniciarCiclo(){
        CicloProgra = new Thread(this.CicloProgra);
        CicloProgra.start();
        Iniciar();
    }
   
    public void Iniciar(){
        //procesos del programa
        double IntervaloDibujo = 1000000000/FPS; //si
        double sigDibu = System.nanoTime() + IntervaloDibujo;
        
        GameLoad();
        while (CicloProgra != null){
            //System.out.println("se esta ejectuando");
            
            GameUpdate();
            
            //con esto se puede llamar al meotodo paintComponent  
            repaint();
           
            try {
                double remaningTime = sigDibu - System.nanoTime();
                remaningTime = remaningTime/1000000;
                
                if(remaningTime < 0){
                    
                    remaningTime = 0;
                }
                Thread.sleep((long)remaningTime);
                sigDibu += IntervaloDibujo;
                System.out.println((long)remaningTime);
            }catch (InterruptedException e){
                e.printStackTrace();
                
            }
        }
    }
   
    //cargar elementos del juego(Graficos, variables, etc...)
    public void GameLoad(){
        System.out.println("Cargando");
        
    } 
    
    //maneja cosas
    public void GameUpdate(){
        
        
        if (this.vsp >= 320-160){
            this.dir2 = -1;
        }else if (this.vsp < 0) {
            this.dir2 = 1;
            }
        
        if (this.hsp >= 480-192){
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
        
    }
    
}
