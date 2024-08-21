import java.applet.Applet;
import java.awt.Graphics;



public class TextBanner extends Applet implements Runnable{

    public void init(){
        Thread th = new Thread(this);
        th.start();

    }

    public void paint(Graphics g) {

        for(int x = 0 ; x < 500 ; x++){
            for(int y = 0 ; y < 500 ; y++){
                g.clearRect(0, 0, getWidth(), getHeight());
                g.drawString("Hello nahass" , y , x);
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