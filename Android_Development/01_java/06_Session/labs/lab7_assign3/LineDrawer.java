import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LineDrawer extends Applet {
    private int x1, y1, x2, y2;

    public void init() {
        x1 = y1 = x2 = y2 = 0;

        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
        addMouseListener(myMouseAdapter);
        addMouseMotionListener(myMouseAdapter);
    }

    public void paint(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }

    class MyMouseAdapter extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();
        }

        public void mouseDragged(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();
            repaint(); 
        }
    }
}
