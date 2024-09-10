import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class PaintBrush extends Applet {
    private Color currentColor = Color.BLACK;
    private String currentShape = "Freehand";
    private boolean filled = false;

    private Shape[] shapes = new Shape[100]; 
    private int shapeCount = 0;

    private int startX, startY, endX, endY;

    public void init() {

        addColorButton("Red", Color.RED);
        addColorButton("Green", Color.GREEN);
        addColorButton("Blue", Color.BLUE);

        addShapeButton("Rectangle");
        addShapeButton("Oval");
        addShapeButton("Line");

        Button freehandBtn = new Button("Freehand");
        freehandBtn.addActionListener(e -> currentShape = "Freehand");
        add(freehandBtn);

        Button eraserBtn = new Button("Eraser");
        eraserBtn.addActionListener(e -> currentShape = "Eraser");
        add(eraserBtn);

        Button clearAllBtn = new Button("Clear All");
        clearAllBtn.addActionListener(e -> {
            shapeCount = 0;
            repaint();
        });
        add(clearAllBtn);

        Checkbox filledChk = new Checkbox("Filled");
        filledChk.addItemListener(e -> filled = filledChk.getState());
        add(filledChk);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                addShape(startX, startY, endX, endY);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (currentShape.equals("Freehand")) {
                    addShape(startX, startY, e.getX(), e.getY());
                    startX = e.getX();
                    startY = e.getY();
                }
            }
        });
    }

    private void addColorButton(String name, Color color) {
        Button colorBtn = new Button(name);
        colorBtn.setBackground(color);
        colorBtn.addActionListener(e -> currentColor = color);
        add(colorBtn);
    }

    private void addShapeButton(String shape) {
        Button shapeBtn = new Button(shape);
        shapeBtn.addActionListener(e -> currentShape = shape);
        add(shapeBtn);
    }

    private void addShape(int x1, int y1, int x2, int y2) {
        if (shapeCount < shapes.length) {
            shapes[shapeCount++] = new Shape(x1, y1, x2, y2, currentColor, currentShape, filled);
            repaint();
        }
    }

    public void paint(Graphics g) {
        for (int i = 0; i < shapeCount; i++) {
            shapes[i].draw(g);
        }
    }

    class Shape {
        int x1, y1, x2, y2;
        Color color;
        String shapeType;
        boolean filled;

        Shape(int x1, int y1, int x2, int y2, Color color, String shapeType, boolean filled) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color = color;
            this.shapeType = shapeType;
            this.filled = filled;
        }

        void draw(Graphics g) {
            g.setColor(color);
            switch (shapeType) {
                case "Rectangle":
                    if (filled) g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
                    else g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
                    break;
                case "Oval":
                    if (filled) g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
                    else g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
                    break;
                case "Line":
                    g.drawLine(x1, y1, x2, y2);
                    break;
                case "Freehand":
                    g.drawLine(x1, y1, x2, y2);
                    break;
                case "Eraser":
                    g.clearRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
                    break;
            }
        }
    }
}
