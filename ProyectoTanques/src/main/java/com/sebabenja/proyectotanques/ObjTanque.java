package com.sebabenja.proyectotanques;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class ObjTanque extends Fisico {
    int velH;
    int velV;
    int giro; 
    Graphics graph;
    //giro
    //KeyHandler keys;
    
    public ObjTanque(int _x, int _y, int _angulo /*,KeyHandler _keys*/){ 
      super(_x, _y, "Circulo");
      this.giro = _angulo;
      //this.keys = _keys;
    }
    
    public void Moverse(KeyHandler keys){
      
       
        if (keys.J1_up){this.x += 2 * Math.cos(this.giro); this.y += 2*Math.sin(this.giro);}
       
        if (keys.J1_down){this.x += -2 * Math.cos(this.giro); this.y += -2*Math.sin(this.giro);}
        
        if (keys.J1_right){this.giro += 1;}
        
        if (keys.J1_left){this.giro += -1;}
        
    }
   
    public void Disparar(){
    
    }
    
    public void Dibujar(Graphics _graph){
      this.graph = _graph;
      Graphics2D Sprite = (Graphics2D)graph;
      Sprite.setColor(Color.red);
      Sprite.fillOval(this.x,this.y,32,32);
      Sprite.setColor(Color.blue);
      //Sprite.rotate(this.giro);
      Sprite.fillRect(this.x+8,this.y+8,16,32);
      
    }   

}
