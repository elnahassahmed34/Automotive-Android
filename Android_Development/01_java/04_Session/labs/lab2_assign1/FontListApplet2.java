import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;

public class FontListApplet2 extends Applet {

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        int y = 20;

        for (String fontName : fonts) {
            Font font = new Font(fontName, Font.PLAIN, 14);
            g2d.setFont(font);
            g2d.drawString(fontName, 20, y);
            y += 20;
        }
    }
}
