/*e
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebabenja.proyectotanques;

//setea colores
import java.awt.Color;
//trabaja con dimensiones
import java.awt.Dimension;
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
            
            GameDraw();
        }
    }
   
    //cargar elementos del juego(Graficos, variables, etc...)
    public void GameLoad(){
        System.out.println("Cargando");
    } 
    
    public void GameUpdate(){
        
    }
    //dibuja las cosas para el juego
    public void GameDraw(){
    
    }
    
}
