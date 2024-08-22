import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;

public class CounterApplet extends Applet {
    
    private int counter;
    private Button btnInc;
    private Button btnDec;
    
    @Override
    public void init() {
        counter = 0;
        btnInc = new Button(" + ");
        btnDec = new Button(" - ");
        add(btnInc);
        add(btnDec);
        
        IncListener incListener = new IncListener();
        btnInc.addActionListener(incListener);
        
        btnDec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter--;
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        g.drawString("" + counter, getWidth() / 2, getHeight() / 2);
    }

    class IncListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            counter++;
            repaint();
        }
    }


}
