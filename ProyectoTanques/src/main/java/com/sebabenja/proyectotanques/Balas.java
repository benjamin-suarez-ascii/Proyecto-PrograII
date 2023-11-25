package com.sebabenja.proyectotanques;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Balas extends ECirculo{
	int daño;
	int velocidad;
	double angulo;
	int duracion = 50;
	
	public Balas(int _id ,int _daño, int velocidad ,int _x, int _y, double _angulo){
		super(_id , _x, _y, 4 );
		this.velocidad = velocidad;
		this.daño = _daño;
		this.angulo = _angulo;
		setImage();
	}
	
	public void update() {
        this.x += this.velocidad * Math.cos(Math.toRadians(angulo));
        this.y += this.velocidad * Math.sin(Math.toRadians(angulo));
        this.duracion -= 1;
        
        
    }
	
	public void balaspego(Balas A) {
		if (this.ColiCir(A))
		{
			if (this.id != A.id) 
			{A.duracion = -1; this.duracion = -1;}
			
		}
	}
	
public void setImage(){
        
        try{
        if (this.id == 1) {
           this.SprObj = ImageIO.read(getClass().getResourceAsStream("/Images/SprBala1.png"));}
        else
        	{this.SprObj = ImageIO.read(getClass().getResourceAsStream("/Images/SprBala2.png"));	}
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
	
	public void Dibujar(Graphics2D Sprite){
	      
	     
	      BufferedImage image = null;
	      
	      image = this.SprObj;
	      
	      
	      AffineTransform transform = new AffineTransform();
	      transform.rotate(Math.toRadians(angulo), image.getWidth() / 2, image.getHeight() / 2);
	      AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
	      
	      image = op.filter(image, null);
	      Sprite.drawImage(image, this.x, this.y,image.getWidth()/2,image.getHeight()/2,null);
	      
	    } 
	
	
	
}

