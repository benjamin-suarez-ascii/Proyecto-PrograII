package com.sebabenja.proyectotanques;


import java.io.IOException;
import java.util.LinkedList;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class ObjTanque extends ECirculo {
    
	int vida = 3;
	double velH; double velV;
    double giro; double subx; double suby;
    int MovSpd = 10; int velangle = 25; float subangle = 0; int subpix = 4;
    boolean kup,kdown,kleft,kright;
    boolean shoot = true;
    LinkedList<Balas> LBala = new LinkedList<Balas>();
    //giro
    //KeyHandler keys;
    
    public ObjTanque(int _id, int _x, int _y, int _angulo){ 
      super(_id , _x, _y, 17 );
      this.giro = _angulo;
      this.subangle = _angulo*10;
      this.subx = _x*subpix;
      this.suby = _y*subpix;
     
      //this.keys = _keys;
      setImage();
    }
    
   
    
    public void Moverse(KeyHandler keys){
       
    	if (this.id == 1) {
    		this.kup = keys.J1_up;
    		this.kdown = keys.J1_down;
    		this.kleft = keys.J1_left;
    		this.kright = keys.J1_right;
    	} else {
    		this.kup = keys.J2_up;
    		this.kdown = keys.J2_down;
    		this.kleft = keys.J2_left;
    		this.kright = keys.J2_right;
    	}
    	
    	
        //aun anda muy bug esta cosa.
        if (this.kup && !this.kdown){
            this.velH = MovSpd*Math.cos(Math.toRadians(giro)); 
            this.velV = MovSpd*Math.sin(Math.toRadians(giro));
        }
        //esta cosa hay que configurarla bien
        else if (this.kdown && !this.kup){
            this.velH = -MovSpd*Math.cos(Math.toRadians(giro)); 
            this.velV = -MovSpd*Math.sin(Math.toRadians(giro));
        }
        //esto es para que no se mueva al inifito
        else {this.velH = 0; this.velV = 0;}
        
        if (this.kleft){subangle += -velangle;}
        
        if (this.kright) {subangle += velangle;}
        
        this.giro = Math.floor(subangle/10);
        if (subangle > 359*10){
            subangle = 0;
        }
        else if (subangle < 0){
            this.subangle = 359*10;
        }
        
        if (this.x+this.velH <= 0)
		{this.velH = 0;}
        if (this.y+this.velV <= 0)
		{this.velV = 0;}
        if (this.x+this.velH >= 640)
		{this.velH = 0;}
        if (this.y+this.velV >= 480)
		{this.velV = 0;}
        
        
        //System.out.println(subangle);
        //System.out.println(giro);
        this.subx += this.velH;
        this.suby += this.velV;
        
        this.x = (int)Math.floor(this.subx/subpix);
        this.y = (int)Math.floor(this.suby/subpix);
        
        for (Balas A : this.LBala)
        {	
        	
        	A.update();
        	A.balaspego(A);
        	if (A.duracion < 0) {
        		this.LBala.remove(A);
        	}
        }
        
    }
   
    public void Disparar(){
    	
    	if (this.LBala.size() < 10){
    		this.LBala.add(new Balas(this.id, 1, 10 , this.x, this.y, this.giro));
    	}	
    }
    
    public boolean RecibirDaño(ObjTanque T){
    	for(Balas A: T.LBala)
    	{
    		if (this.ColiCir(A))
    		{
    			T.LBala.remove(A);
    			return true;
    		}
    	}
    	return false;
    }
    
    public void ColiTank(ObjTanque e){
        if (this.id != e.id ){	
    		if (this.ColiCir(e)){
        			this.subx = (this.x - this.velH)*subpix;
        			this.suby = (this.y - this.velV)*subpix;
        			this.velH = 0;
        			this.velV = 0;}
        	}
        
    }
    
    public void setImage(){
        
        try{
           if (this.id == 1) {
        	this.SprObj = ImageIO.read(getClass().getResourceAsStream("/Images/SprPlayer1.png"));}
           else
           {this.SprObj = ImageIO.read(getClass().getResourceAsStream("/Images/SprPlayer2.png"));	}
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void Dibujar(Graphics2D Sprite){
    	for (Balas A : this.LBala){
        	A.Dibujar(Sprite);
        }
    	
      BufferedImage image = null;
      
      image = this.SprObj;
      
      
      AffineTransform transform = new AffineTransform();
      transform.rotate(Math.toRadians(giro), image.getWidth() / 2, image.getHeight() / 2);
      AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
      
      image = op.filter(image, null);
      Sprite.drawImage(image, this.x-radio, this.y-radio,image.getWidth()/2,image.getHeight()/2,null);
      
      
    }   

}
