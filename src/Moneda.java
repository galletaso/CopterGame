
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
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
public class Moneda extends Ellipse2D.Double{
    /*Rectangle2D obstaculo;
    double alturaObstaculo =125;
    int anchoObstaculo = 45;
    private int anchoPantalla;*/
    
    Image skin;
    
    public Moneda(){
        super(500,150,50,50);
        Ellipse2D moneda = new Ellipse2D.Double(500,150,50, 50);
        precargaImagenes();
    }
    
    public void precargaImagenes(){
        skin= (new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/coin.gif")).
               getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT))).getImage();
    }
    
    public void mueve(Graphics2D g2){
        mueveMoneda();
        g2.setColor(Color.YELLOW);
        g2.fill(moneda);
        //g2.drawImage(col_abajo, (int)base.getX(), (int)base.getY(), null);
        //g2.drawImage(col_arriba, (int)capitel.getX(), (int)capitel.getY(), null);
    }
    
    private void mueveMoneda(){
        if(moneda.getX() + moneda.width <=0){
            Random aleatorio = new Random();
            int desplazamiento = aleatorio.nextInt(500);
            moneda.setFrame(1075, desplazamiento,moneda.width(),moneda.height());    
        }else{
            moneda.setFrame(moneda.getX()-10, moneda.getY(),moneda.width(),moneda.height());
        }   
    }
    
    
}
