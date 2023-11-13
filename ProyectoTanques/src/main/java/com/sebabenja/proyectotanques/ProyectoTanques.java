package com.sebabenja.proyectotanques;

import javax.swing.JFrame;
//lo controles fallaron porque no supe como funcionaban y tenia que ordenalos, tendre que estudiar causas.
public class ProyectoTanques {

    public static void main(String[] args) {
        
        //se crea una clase Jframe que es la pantalla
        JFrame pantalla = new JFrame();
        JuegoConf Juego = new JuegoConf();
        //Esto sirve para que cierre todas las operaciones cuando se cierre 
        //el programa, de lo contrario se quedara en un segundo plano
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //se puede leer normal.
        
        pantalla.setTitle("Progra2");
        
        //se llama a la configuracion
        
        pantalla.add(Juego);
        pantalla.pack();
        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(true);
        //aqui inicia lo del thread y eso
        Juego.IniciarCiclo();
        
    }
}
