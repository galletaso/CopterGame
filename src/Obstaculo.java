
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xp
 */
public class Obstaculo {
    Rectangle2D obstaculo;
    double alturaObstaculo =125;
    int anchoObstaculo = 45;
    private int anchoPantalla;
    
    public Obstaculo (int _posY, int _anchoPantalla) {
        
        Random aleatorio = new Random();
        int desplazamiento = aleatorio.nextInt(200);
        obstaculo = new Rectangle2D.Double(_posY, desplazamiento, anchoObstaculo, alturaObstaculo);
        
        anchoPantalla = _anchoPantalla;
        //precargaImagenes();
    }
    public void mueve(Graphics2D g2){
        mueveColumna();
        //g2.setColor(Color.GREEN);
        g2.fill(obstaculo);
        //g2.drawImage(col_abajo, (int)base.getX(), (int)base.getY(), null);
        //g2.drawImage(col_arriba, (int)capitel.getX(), (int)capitel.getY(), null);
    }
    
    private void mueveColumna(){
        if(obstaculo.getX() + anchoObstaculo <=0){
            Random aleatorio = new Random();
            int desplazamiento = aleatorio.nextInt(500);
            obstaculo.setFrame(anchoPantalla, desplazamiento,obstaculo.getWidth(),obstaculo.getHeight());    
        }else{
            obstaculo.setFrame(obstaculo.getX()-10, obstaculo.getY(),obstaculo.getWidth(),obstaculo.getHeight());
        }   
    }
    
}
