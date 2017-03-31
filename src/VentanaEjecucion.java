
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alfonso González Laguna
 */
public class VentanaEjecucion extends javax.swing.JFrame {

    public int puntuacionAUX;
    public int puntuacion =0;//variable para la puntuación
    public static int puntuacionMax ;//variable para la puntuación máxima
    
    int i =0;//variable entera en desuso
    
    //variable booleana para indicar el fin del juego
    boolean gameOver = false;
    
    //objeto de la clase helicóptero que será el que controlaremos
    Helicoptero helicoptero = new Helicoptero(60);
    
    //objetos de la clase obstáculo que supondrán los obstáculos
    Obstaculo obstaculo = new Obstaculo(1000, ANCHOPANTALLA);
    Obstaculo obstaculo2 = new Obstaculo(1300, ANCHOPANTALLA);
    Obstaculo obstaculo3 = new Obstaculo(1600, ANCHOPANTALLA);
    
    Moneda moneda = new Moneda();
    
    static int ANCHOPANTALLA = 1075;//variable entera para el ancho de la pantalla
    static int ALTOPANTALLA = 570;//variable entera para el alto de la pantalla
    
    Path[] camino = new Path[32];//array de objetos de la clase Path que supondrán el camino por el que se moverá el copter
    
    
    BufferedImage buffer = null;
    Graphics2D bufferGraphics, lienzoGraphics = null;
    
    int contador = 0;//variable para el contador de puntuación, ahora en desuso
    
    /**
     * Constructor de la clase VentanaEjecucion que es la ventana que se ejecuta.
     */
    public VentanaEjecucion() {
        
        initComponents();
        inicializaBuffers();
        //bucle que genera el camino
        for(int i = 0; i<32;i++){
            camino[i] = new Path(i*35, ANCHOPANTALLA);
        }
        i=0;
        temporizador.start();
    }
    
    /**
     * Temporizador que corre mientras la variable "gameOver" se mantenga en 'false'
     */
    Timer temporizador = new Timer(10,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            
            bucleDelJuego();
            puntuacion++;
        }
    });
    
    /**
     * Método que inicializa los buffers en los que se cargaran los "gráficos"
     */
    private void inicializaBuffers(){
        
        lienzoGraphics = (Graphics2D) jPanel1.getGraphics();
        buffer = (BufferedImage) jPanel1.createImage(ANCHOPANTALLA, ALTOPANTALLA);
        bufferGraphics = buffer.createGraphics();
        
        
        bufferGraphics.fillRect(0,0, ANCHOPANTALLA, ALTOPANTALLA);

    }
    
    
    /**
     * Método que se ejecuta continuamente para ejecutar la animación del juego
    */
    private void bucleDelJuego(){
        
        //siguientes dos lineas limpian la pantalla
        if(puntuacion <500){
            bufferGraphics.setColor(Color.GREEN);
        }else if(puntuacion>500||puntuacion<600){
            bufferGraphics.setColor(new Color(255,0,255));
        }else if (puntuacion>600){
            bufferGraphics.setColor(new Color(255,165,0));
        }
        
        bufferGraphics.fillRect(0,0, ANCHOPANTALLA, ALTOPANTALLA);
        
        //bucle que mueve el camino
        for(int i = 0; i<32;i++){
            camino[i].mueve(bufferGraphics);
            if(helicoptero.chequeaColision(camino[i])){
            reiniciaJuego();
            }
        }
        
        //dibujamos el helicoptero y los obstáculos
        helicoptero.mueve(bufferGraphics);
        
        obstaculo.mueve(bufferGraphics);
        obstaculo2.mueve(bufferGraphics);
        obstaculo3.mueve(bufferGraphics);
        
        //moneda.mueve(bufferGraphics);
        
        //si gameOver se torna false, para el juego
        if(gameOver){               
               reiniciaJuego();
            }
        
        //Recoge las colisiones con los obstaculos
        if(helicoptero.chequeaColision(obstaculo) || helicoptero.chequeaColision(obstaculo2) || helicoptero.chequeaColision(obstaculo3)){            
            reiniciaJuego();
        }
        
        /*if(helicoptero.chequeaColision(moneda)){
            bufferGraphics.setColor(new Color.Random);
        }*/
        
        //siguientes dos lineas dibujan la puntuacion
        bufferGraphics.setFont(new Font("Courier New", Font.BOLD, 20));
        bufferGraphics.setColor(Color.BLACK);
        bufferGraphics.drawString("distance: " + puntuacion, 900, 550);
        if (puntuacion > puntuacionMax){
            puntuacionMax = puntuacion;
        }
        bufferGraphics.drawString("best: " + puntuacionMax, 50, 550);
        
        //redibuja la escena
        lienzoGraphics.drawImage(buffer, 0, 0, this);
        
        //precargaImagenes();
       
        
    }
    
    /**
     * Método que reinicia el juego con la puntuación a 0 y el récord de la partida anterior
     */
    public void reiniciaJuego(){
        //reinicia = new Reinicia(puntuacionMax);
        //puntuacionAUX  = puntuacionMax;
        temporizador.stop();
        this.setVisible(false);
        //puntuacionMax = reinicia.puntuacionMax();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1075, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para mover el helicóptero hacia arriba con la barra espaciadora
     * @param evt evento para recoger la tecla presionada, en este caso para recoger el espacio
     */
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_SPACE){
                helicoptero.yVelocidad=4.5;
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaEjecucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEjecucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEjecucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEjecucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEjecucion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
