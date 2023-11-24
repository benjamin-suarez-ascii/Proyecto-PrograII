//TECLAO
package com.sebabenja.proyectotanques;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    
    //lista de botones
    public boolean J1_up , J2_up , J1_down, J2_down , J1_left, J2_left , J1_right, J2_right,J1_shoot,J2_shoot; 
    boolean active1;
    
    @Override
    public void keyTyped(KeyEvent e) {   
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
         switch(code){
            //Jugador 1
            case KeyEvent.VK_W: this.J1_up = true ;break;
            case KeyEvent.VK_A: this.J1_left = true;break;
            case KeyEvent.VK_S: this.J1_down = true;break;
            case KeyEvent.VK_D: this.J1_right = true;break;
            case KeyEvent.VK_T: this.J1_shoot = true;break;
            //Jugador 2
            case KeyEvent.VK_UP: this.J2_up = true;break;
            case KeyEvent.VK_LEFT: this.J2_left = true;break;
            case KeyEvent.VK_DOWN: this.J2_down = true;break;
            case KeyEvent.VK_RIGHT: this.J2_right = true;break;
            case KeyEvent.VK_SHIFT: this.J2_shoot = true;break;
        }
    }    
       
    @Override
    public void keyReleased(KeyEvent e) {
      int code = e.getKeyCode();
        
        
        switch(code){
            //Jugador 1
            case KeyEvent.VK_W: this.J1_up = false;break;
            case KeyEvent.VK_A: this.J1_left = false;break;
            case KeyEvent.VK_S: this.J1_down = false;break;
            case KeyEvent.VK_D: this.J1_right = false;break;
            case KeyEvent.VK_T: this.J1_shoot = false;break;
            //Jugador 2
            case KeyEvent.VK_UP: J2_up = false;break;
            case KeyEvent.VK_LEFT: J2_left = false;break;
            case KeyEvent.VK_DOWN: J2_down = false;break;
            case KeyEvent.VK_RIGHT: J2_right = false;break;
            case KeyEvent.VK_SHIFT: J2_shoot = false;break;
        }
    }


}