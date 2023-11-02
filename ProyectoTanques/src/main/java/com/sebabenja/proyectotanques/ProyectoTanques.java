package com.sebabenja.proyectotanques;

import javax.swing.JFrame;

public class ProyectoTanques {

    public static void main(String[] args) {
        
        //se crea una clase Jframe que es la pantalla
        JFrame pantalla = new JFrame();
        
        //Esto sirve para que cierre todas las operaciones cuando se cierre 
        //el programa, de lo contrario se quedara en un segundo plano
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //se puede leer normal.
        pantalla.setVisible(true);
        pantalla.setTitle("Progra2");
        
        //se llama a la configuracion
        JuegoConf Juego = new JuegoConf();
        pantalla.add(Juego);
        pantalla.pack();
        
        //aqui inicia lo del thread y eso
        Juego.IniciarCiclo();
        
    }
}
