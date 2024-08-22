import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationBall extends Applet implements Runnable {

    int width = 40, height = 40;
    boolean moveRight = true;
    boolean moveDown = true;
    Thread myThread;
    
    Button btnStart, btnPause;

    @Override
    public void init() {
        
        btnStart = new Button("Start");
        btnPause = new Button("Pause");
        
        add(btnStart);
        add(btnPause);
        
        class StartListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if (myThread == null) {
                    myThread = new Thread(AnimationBall.this);
                    myThread.start();
                } else {
                    myThread.resume();
                }
            }
        }
        
        class PauseListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                myThread.suspend();
            }
        }

        StartListener startListener = new StartListener();
        PauseListener pauseListener = new PauseListener();
        
        btnStart.addActionListener(startListener);
        btnPause.addActionListener(pauseListener);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(width, height, 20, 20);
    }

    public void run() {
        while (true) {
            try {
                repaint();

                if (moveRight) {
                    width += 10;
                    if (width >= getWidth() - 20) {
                        moveRight = false;
                    }
                } else {
                    width -= 10;
                    if (width <= 0) {
                        moveRight = true;
                    }
                }

                if (moveDown) {
                    height += 10;
                    if (height >= getHeight() - 20) {
                        moveDown = false;
                    }
                } else {
                    height -= 10;
                    if (height <= 0) {
                        moveDown = true;
                    }
                }

                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
