import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

public class TimeApplet extends Applet {

    private TimeUpdater timeThread;

    public void init() {
        timeThread = new TimeUpdater();
        timeThread.start();
    }

    @Override
    public void paint(Graphics g) {
        Date d = new Date();
        g.drawString(d.toString(), getWidth() / 2, getHeight() / 2);
    }

    private class TimeUpdater extends Thread {
    
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    repaint();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
}
