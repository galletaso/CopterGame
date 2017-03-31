
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xp
 */
public class Helicoptero extends Ellipse2D.Double{
    
    int i = 0;
    
    double yVelocidad = -3;
    
    Image skin;
    
    public Helicoptero(int _radio){
        super(200, 150, _radio, _radio);
        precargaImagenes();
        Ellipse2D helicoptero = new Ellipse2D.Double(200,150,_radio, _radio);
        precargaImagenes();
    }
    
    public void precargaImagenes(){
        skin= (new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/hover-copter.png")).
               getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT))).getImage();
    }
    
    public void mueve(Graphics2D g2){
        
        this.y = this.y - yVelocidad;
        
        //tope para que no se salga por el techo o suelo
        if(this.y<0){
            this.y = 0;
            yVelocidad = -0.4;
        }else if(this.y>527){
            this.y=527;
            yVelocidad=0;
        }
        g2.setColor(Color.GREEN);
        //g2.fill(this);
        
        yVelocidad -=0.25;
        if(yVelocidad == 0){
            yVelocidad -= 0.25;
        }
        i++;
        
        g2.drawImage(skin, (int)this.getX(), (int)this.getY(), null);
        
    }
    
    public boolean chequeaColision(Path p){
        
        if(this.y<p.camino.getY()-20||this.y>p.camino.getY()+p.camino.getHeight()-20){
            return true;
        }else{
            return false;
        }
        
        /*if(this.intersects(p.camino)) {
            return false;
        }else{
            return true;
        }*/
    }
    
    public boolean chequeaColision(Obstaculo o){
        if(!this.intersects(o.obstaculo)) {
            return false;
        }else{
            return true;
        }
    }
    
    /*public boolean chequeaColision(Moneda m){
        if(!this.intersects(m.moneda)) {
            return false;
        }else{
            return true;
        }
    }*/
}
