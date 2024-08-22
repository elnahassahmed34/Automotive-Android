import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LineDrawer extends Applet {

    Line[] lines = new Line[3]; 
    int lineCount = 0; 
    int x1, y1; 

    public void init() {
        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
        addMouseListener(myMouseAdapter);
        addMouseMotionListener(myMouseAdapter);
    }

    public void paint(Graphics g) {
        for (int i = 0; i < lineCount; i++) {
            if (lines[i] != null) {
                g.drawLine(lines[i].x1, lines[i].y1, lines[i].x2, lines[i].y2);
            }
        }
    }

    class Line {
        int x1, y1, x2, y2;
    

        Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    class MyMouseAdapter extends MouseAdapter {
      
        public void mousePressed(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();
        }

        public void mouseReleased(MouseEvent e) {
      
            if (lineCount < 3) { 
                int x2 = e.getX();
                int y2 = e.getY();
                lines[lineCount] = new Line(x1, y1, x2, y2);
                lineCount++;
                repaint(); 
            }
        }
    }
}
