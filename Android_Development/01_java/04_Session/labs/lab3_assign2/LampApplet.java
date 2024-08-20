import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class LampApplet extends Applet {

    @Override
    public void paint(Graphics g) {
        
        g.setColor(Color.YELLOW);
        g.fillOval(100, 50, 200, 50); 
        
        g.setColor(Color.BLACK);
        g.drawLine(100, 75, 50, 200); 
        g.drawLine(300, 75, 350, 200); 
        g.drawLine(50, 200, 350, 200); 

        
        g.drawRect(175, 300, 100, 50); 

       
        g.drawLine(200, 200, 200, 300); 
        g.drawLine(250, 200, 250, 300); 

        g.setColor(Color.ORANGE);
        g.fillOval(120, 100, 50, 60); 
        g.fillOval(230, 100, 50, 60); 
        g.fillOval(175, 110, 50, 80); 
    }
}
