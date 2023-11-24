package com.sebabenja.proyectotanques;


import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class ObjTanque extends ECirculo {
    double velH;
    double velV;
    double giro;
    double subx;
    double suby;
    int MovSpd = 1;
    float subangle = 0;
    int subpix = 4;
    //giro
    //KeyHandler keys;
    
    public ObjTanque(int _id, int _x, int _y, int _angulo /*,KeyHandler _keys*/){ 
      super(_id , _x, _y, 30 );
      this.giro = _angulo;
      //this.keys = _keys;
     
      setImage();
    }
    
    public void Moverse(KeyHandler keys){
       
        
        //aun anda muy bug esta cosa.
        if (keys.J1_up && !keys.J1_down){
            this.velH = MovSpd*Math.cos(Math.toRadians(giro)); 
            this.velV = MovSpd*Math.sin(Math.toRadians(giro));
        }
        //esta cosa hay que configurarla bien
        else if (keys.J1_down && !keys.J1_up){
            this.velH = -MovSpd*Math.cos(Math.toRadians(giro)); 
            this.velV = -MovSpd*Math.sin(Math.toRadians(giro));
        }
        //esto es para que no se mueva al inifito
        else {this.velH = 0; this.velV = 0;}
        
        if (keys.J1_right){subangle += -3;}
        
        if (keys.J1_left) {subangle += 3;}
        
        
        this.giro = Math.floor(subangle/10);
        if (subangle > 359*10){
            subangle = 0;
        }
        else if (subangle < 0){
            subangle = 359*10;
        }
        
        System.out.println(subangle);
        System.out.println(giro);
        this.subx += this.velH;
        this.suby += this.velV;
        
        this.x = (int)Math.floor(this.subx/subpix);
        this.y = (int)Math.floor(this.suby/subpix);
        
    }
   
    public void Disparar(){
        
    }
    
    public void setImage(){
        
        try{
           SprObj = ImageIO.read(getClass().getResourceAsStream("/Images/SprPlayer1.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void Dibujar(Graphics2D Sprite){
      
      /*Sprite.setColor(Color.red);
      //circulo
      Sprite.fillOval(this.x,this.y,32,32);
      Sprite.rotate(Math.toRadians(giro));
      Sprite.setColor(Color.blue);
      Sprite.fillRect(this.x+8,this.y+8,32,16);
      Sprite.rotate(Math.toRadians(0));
      
      //la cosa de la rotacion que no se usarla bien
      */
      BufferedImage image = null;
      
      image = this.SprObj;
      
      
      AffineTransform transform = new AffineTransform();
      transform.rotate(Math.toRadians(giro), image.getWidth() / 2, image.getHeight() / 2);
      AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
      
      image = op.filter(image, null);
      Sprite.drawImage(image, this.x, this.y,image.getWidth(),image.getHeight(),null);
      
    }   

}
