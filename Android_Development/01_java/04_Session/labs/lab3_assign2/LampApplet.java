import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class LampApplet extends Applet {

    
    public void paint(Graphics g) {
        
        g.setColor(new Color(255, 255, 153));

        
        g.fillOval(100, 50, 200, 50);

        
        g.setColor(Color.BLACK);
        g.drawLine(100, 75, 75, 200);  
        g.drawLine(300, 75, 325, 200); 
        g.drawArc(75, 190, 250, 20, 0, -180); 

        
        g.setColor(new Color(255, 255, 153));
        g.fillOval(170, 100, 60, 100); 
        g.fillOval(110, 110, 40, 80);  
        g.fillOval(250, 110, 40, 80);  

        
        g.setColor(Color.BLACK);
        g.drawOval(170, 100, 60, 100); 
        g.drawOval(110, 110, 40, 80);  
        g.drawOval(250, 110, 40, 80);  

        
        g.drawLine(190, 210, 170, 300); 
        g.drawLine(210, 210, 230, 300); 

        
        g.drawRect(160, 300, 80, 20);
    }
}