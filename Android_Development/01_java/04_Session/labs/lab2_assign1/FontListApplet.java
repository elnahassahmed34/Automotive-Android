import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;

public class FontListApplet extends Applet {
    
    @Override
    public void paint(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        
        String[] fonts = toolkit.getFontList();

        int y = 20;

        for (String fontName : fonts) {
            Font font = new Font(fontName, Font.PLAIN, 14);
            g2d.setFont(font);
            g2d.drawString(fontName, 20, y);
            y += 20;  
        }
    }
}
