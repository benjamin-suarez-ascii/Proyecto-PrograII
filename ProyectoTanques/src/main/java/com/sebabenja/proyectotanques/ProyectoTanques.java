package com.sebabenja.proyectotanques;

import javax.swing.JFrame;
//lo controles fallaron porque no supe como funcionaban y tenia que ordenalos, tendre que estudiar causas.
public class ProyectoTanques {

    public static void main(String[] args) {
        
        //se crea un objeto Jframe que es la pantalla
        JFrame pantalla = new JFrame();
        //se crea un objeto de juego para ejecutarlo
        JuegoConf Juego = new JuegoConf();
        //Esto sirve para que cierre todas las operaciones cuando se cierre 
        //el programa, de lo contrario se quedara en un segundo plano
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //se puede leer normal.
        pantalla.setTitle("Tanques TopDown");
        //se añade la configuracion del juego
        pantalla.add(Juego);
        //lo une a la pantalla
        pantalla.pack();
        //no me acuerdo que hacia
        pantalla.setLocationRelativeTo(null);
        
        pantalla.setVisible(true);
        //aqui inicia lo del thread y eso, osea inicia el ciclo del juego
        Juego.IniciarCiclo();
        
    }
}
