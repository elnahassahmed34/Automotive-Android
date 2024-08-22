import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

public class TimeApplet extends Applet {

    @Override
    public void init() {
        // Create and start the thread with an anonymous inner class
        new Thread() {
            @Override
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
        }.start();
    }

    @Override
    public void paint(Graphics g) {
        Date d = new Date();
        g.drawString(d.toString(), getWidth() / 2, getHeight() / 2);
    }
}
