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

public class PantaConf extends JPanel {
    final int tamCasilla = 16;
    final int P_ancho = 320;
    final int  P_alto = 240;
    
    Thread CicloProgra;
    
    public PantaConf(){
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
    }

    public void Programajava(){
        //procesos del programa
        GameLoad();
        while (CicloProgra != null){
            GameUpdate();
            System.out.print("se esta ejectuando");
            GameDraw();
        }
    }
   public void GameLoad(){
   
   } 
    
    public void GameUpdate(){
    
    }
    
    public void GameDraw(){
    
    }
    
}
