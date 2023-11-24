package com.sebabenja.proyectotanques;

import java.awt.image.BufferedImage;

public class Entidad{
   int id;      //id del objeto
   int x = 0;   //Posición X
   int y = 0;   //posicion Y
   int cx = 0;
   int cy = 0;
   public BufferedImage SprObj;
   //constructor
   public Entidad(int _id ,int _x, int _y, int _cx, int _cy){
      this.id = _id;
      this.x = _x;
      this.y = _y;
      this.cx = _cx;
      this.cy = _cy;
   }
   
   public void setPosicion( int _x, int _y){
      this.x = _x;
      this.y = _y;
   }
}
   
class ERectangulo extends Entidad{
   
   int ancho;   //Ancho del rectangulo
   int largo;   //largo del rectangulo

   //Mask de Hitbox
   int BoxLeft; 
   int BoxRight;
   int BoxUp;
   int BoxDown;
  
   
   public ERectangulo(int _x, int _y, int cx, int cy, int _w, int _h, int _id){
        super(_id, _x, _y,cx,cy);
        this.ancho = _w;
        this.largo = _h;
   }
   
   public void UpdtColi(){
       this.BoxLeft = this.x;
       this.BoxRight = this.x + this.ancho;
       this.BoxUp = this.y;
       this.BoxDown = this.y + this.largo;
   }
   
   public void ColiRec(ERectangulo _objeto){
      if (this.BoxLeft > _objeto.BoxRight && this.BoxRight < _objeto.BoxLeft 
      && this.BoxUp > _objeto.BoxDown && this.BoxDown < _objeto.BoxUp);
   }
   
}

class ECirculo extends Entidad{
   int radio;   //radio de circulo
   public ECirculo(int _id ,int _x,int _y,int _r){
      super(_id, _x, _y,0,0);
      this.radio = _r;
      }
}
  
  