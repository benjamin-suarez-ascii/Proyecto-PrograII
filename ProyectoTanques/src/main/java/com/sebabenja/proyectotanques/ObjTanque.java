package com.sebabenja.proyectotanques;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class ObjTanque extends Entidad {
    int velH;
    int velV;
    double giro; 
    Graphics graph;
    //giro
    //KeyHandler keys;
    
    public ObjTanque(int _x, int _y, int _angulo /*,KeyHandler _keys*/){ 
      super(_x, _y, "Circulo");
      this.giro = _angulo;
      //this.keys = _keys;
    }
    
    public void Moverse(KeyHandler keys){
      
        //aun anda muy bug esta cosa.
        if (keys.J1_up)   {this.velH += 2 * Math.cos(this.giro); this.y += 2*Math.sin(this.giro);}
        //esta cosa hay que configurarla bien
        //else if (keys.J1_down) {this.velV -= 2 * Math.cos(this.giro); this.y -=2*Math.sin(this.giro);}
        //esto es para que no se mueva al inifito
        else {this.velH = 0; this.velV = 0;}
        
        if (keys.J1_right){this.giro += -1;}
        
        if (keys.J1_left) {this.giro += 1;}
        
        this.x += this.velH;
        this.y += this.velV;
    }
   
    public void Disparar(){
        
    }
    
    public void Dibujar(Graphics _graph){
      this.graph = _graph;
      
      Graphics2D Sprite = (Graphics2D)graph;
      //Sprite.rotate(this.giro);
      
      Sprite.setColor(Color.red);
      //circulo
      Sprite.fillOval(this.x,this.y,32,32);
      Sprite.setColor(Color.blue);
      //la cosa de la rotacion que no se usarla bien
      //Sprite.rotate(Math.toRadians(giro));
      
      Sprite.fillRect(this.x+8,this.y+8,16,32);
      
    }   

}
