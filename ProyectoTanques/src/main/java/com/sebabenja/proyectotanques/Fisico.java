package com.sebabenja.proyectotanques;

public class Fisico{
   int x = 0;   //Posición X
   int y = 0;   //posicion Y
   int ancho;   //Ancho del rectangulo
   int largo;   //largo del rectangulo
   int radio;   //radio de circulo
   String Tipo; //Rectangulo ; Circulo
   
   //Mask
   int BoxLeft; 
   int BoxRight;
   int BoxUp;
   int BoxDown;
   
   
   
   
   public Fisico(int _x, int _y, String _tipo){
      this.x = _x;
      this.y = _y;
      this.Tipo = _tipo;
   }
   
   public void setPosicion( int _x, int _y){
      this.x = _x;
      this.y = _y;
   }
   
   public void setRectangulo(int _w, int _h){
      if (this.Tipo == "Rectangulo" ){ 
         this.ancho = _w;
         this.largo = _h;
         this.BoxLeft = this.x;
         this.BoxRight = this.x + this.ancho;
         this.BoxUp = this.y;
         this.BoxDown = this.y + this.largo;
      }
   }
   
   public void setCirculo(int _r){
      if (this.Tipo == "Circulo" ){
         this.radio = _r;
      }
   }
   
  // public int getAreaRec(){
      
  // }
   
  // public int getAreaCir(){
      
  // }
   
   public int getPosicion(){
      return this.x;
    }
   

   public void ColiRec(Fisico _objeto){
      if (this.BoxLeft > _objeto.BoxRight && this.BoxRight < _objeto.BoxLeft 
      && this.BoxUp > _objeto.BoxDown && this.BoxDown < _objeto.BoxUp);
   }

}