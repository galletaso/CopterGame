/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;
/**
 *
 * @author xp
 */
public class Path {
    
    int i=0;
    
    Rectangle2D camino;
    double alturaCamino =470;
    int anchoCamino = 150;
    private int anchoPantalla;
    
    public Path (int _posY, int _anchoPantalla) {
        
        Random aleatorio = new Random();
        int desplazamiento = aleatorio.nextInt(30);
        camino = new Rectangle2D.Double(_posY, desplazamiento, anchoCamino, alturaCamino);
        
        anchoPantalla = _anchoPantalla;
        //precargaImagenes();
    }
    
    public void mueve(Graphics2D g2){
        i++;
        mueveColumna();
        g2.setColor(Color.BLACK);
        g2.fill(camino);
        //g2.drawImage(col_abajo, (int)base.getX(), (int)base.getY(), null);
        //g2.drawImage(col_arriba, (int)capitel.getX(), (int)capitel.getY(), null);
    }
    
    private void mueveColumna(){
        if(camino.getX() + anchoCamino <=0){
            Random aleatorio = new Random();
            int desplazamiento = aleatorio.nextInt(50);
            camino.setFrame(anchoPantalla, desplazamiento,camino.getWidth(),camino.getHeight());    
        }else{
            camino.setFrame(camino.getX()-10, camino.getY(),camino.getWidth(),camino.getHeight());//el primer parámetro de setFrame controla la velocidad
        }   
    }
    
}
