import java.applet.Applet;
import java.awt.Graphics;



public class AnimationBall extends Applet implements Runnable{

    public void init(){
        Thread th = new Thread(this);
        th.start();

    }

    public void paint(Graphics g) {

        for(int x = 0 ; x < 500 ; x+=2){
            for(int y = 0 ; y < 500 ; y+=2){
                g.clearRect(0, 0, getWidth(), getHeight());
                g.fillOval(y, x, 60, 100); 
            }
        }
        
    }

    public void run(){
        while(true){
            try{
                
                Thread.sleep(1000);
                repaint();
            }
            catch(InterruptedException ie){ie.printStackTrace();}
        }
    }
}