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
    final int P_ancho = 320;
    final int  P_alto = 240;
    
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
        
        GameLoad();
        while (CicloProgra != null){
            //System.out.println("se esta ejectuando");
            
            GameUpdate();
            
            //con esto se puede llamar al meotodo paintComponent  
            repaint();
        }
    }
   
    //cargar elementos del juego(Graficos, variables, etc...)
    public void GameLoad(){
        System.out.println("Cargando");
    } 
    
    //maneja cosas
    public void GameUpdate(){
        
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
        g2.fillRect(32,0,128,32);
        g2.fillRect(0,32,192,96);
        g2.fillRect(32,128,128,32);
        //dibuja un rectangulo (auque dibuje una L)
        g2.setColor(Color.green);
        g2.fillRect(64,32,32,96);
        g2.fillRect(96,96,32,32);
    }
    
}
