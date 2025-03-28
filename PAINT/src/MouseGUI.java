package layouts_gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class MouseGUI extends JFrame {
    private JPanel drawPanel;
    private JPanel buttonPanel;
    private ArrayList<Shape> shapes = new ArrayList<>();
    private Shape selectedShape = null;
    private Point lastMousePos;
    private boolean resizeMode = false;
    private boolean drawMode = false; 
    private ArrayList<Point> currentDrawing = new ArrayList<>(); 
    private Color drawColor = Color.BLACK;

    public static void main(String[] args) {
        //crea una instancia de mouseGUI y la muestra en la pantalla
        EventQueue.invokeLater(() -> {
            try {
                MouseGUI frame = new MouseGUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MouseGUI() {
        setTitle("PAINT PIRATEÑO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 400);
        setLayout(new BorderLayout());


        //EXPLICACION : El panel de dibujo es donde se dibujan las formas y el panel de botones contiene los botones para agregar formas, borrar, redimensionar, dibujar y cambiar color.
        drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Shape shape : shapes) {
                    shape.draw(g);
                }
                if (drawMode && !currentDrawing.isEmpty()) { 
                    g.setColor(drawColor);
                    for (int i = 1; i < currentDrawing.size(); i++) {
                        Point p1 = currentDrawing.get(i - 1);
                        Point p2 = currentDrawing.get(i);
                        g.drawLine(p1.x, p1.y, p2.x, p2.y);
                    }
                }
            }
        };
        drawPanel.setBackground(Color.WHITE);
        drawPanel.setPreferredSize(new Dimension(600, 500));
        add(drawPanel, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 1, 10, 10)); // Increase grid rows
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setPreferredSize(new Dimension(180, 500));
        add(buttonPanel, BorderLayout.EAST);

        addButton("Agregar Rectángulo", Color.RED, () -> shapes.add(new RectangleShape(0, 0, 70, 50, Color.RED)));
        addButton("Agregar Círculo", Color.BLUE, () -> shapes.add(new CircleShape(0, 0, 100, 100, Color.BLUE)));
        addButton("Agregar Triángulo", Color.GREEN, () -> shapes.add(new TriangleShape(0, 0, 900, 80, Color.GREEN)));
        addButton("Borrar", Color.DARK_GRAY, () -> {
            if (selectedShape != null) {
                shapes.remove(selectedShape);
                selectedShape = null;
            }
        });
        addButton("Redimensionar", Color.ORANGE, () -> resizeMode = !resizeMode);
        addButton("Dibujar", Color.MAGENTA, () -> drawMode = !drawMode); // Add draw button
        addButton("Cambiar Color", Color.CYAN, () -> {
            Color newColor = JColorChooser.showDialog(MouseGUI.this, "Seleccione un color", drawColor);
            if (newColor != null) {
                drawColor = newColor;
            }
        });

        drawPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (drawMode) {
                    currentDrawing.clear();
                    currentDrawing.add(e.getPoint());
                } else {
                    for (Shape shape : shapes) {
                        if (shape.contains(e.getX(), e.getY())) {
                            selectedShape = shape;
                            shape.selected = true;
                        } else {
                            shape.selected = false;
                        }
                    }
                    drawPanel.repaint();
                    lastMousePos = e.getPoint();
                }
            }
            @Override
            public void mouseReleased(MouseEvent e){
                if (drawMode && !currentDrawing.isEmpty()){
                    currentDrawing.add(e.getPoint());
                    shapes.add(new FreeShape(new ArrayList<>(currentDrawing),drawColor));
                    currentDrawing.clear();
                    drawPanel.repaint();
                }
            }
        });

        drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (drawMode) {
                    currentDrawing.add(e.getPoint());
                } else if (selectedShape != null) {
                    int dx = e.getX() - lastMousePos.x;
                    int dy = e.getY() - lastMousePos.y;

                    if (resizeMode) {
                        selectedShape.width += dx;
                        selectedShape.height += dy;
                        if (selectedShape.width < 10) selectedShape.width = 10;
                        if (selectedShape.height < 10) selectedShape.height = 10;
                    } else {
                        selectedShape.x += dx;
                        selectedShape.y += dy;
                    }

                    lastMousePos = e.getPoint();
                }
                drawPanel.repaint();
            }
        });
    }

    private void addButton(String text, Color color, Runnable action) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.addActionListener(e -> {
            action.run();
            drawPanel.repaint();
        });
        buttonPanel.add(button);
    }
}

abstract class Shape {
    int x, y, width, height;
    Color color;
    boolean selected;

    public Shape(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.selected = false;
    }

    public abstract void draw(Graphics g);
    public boolean contains(int px, int py) {
        return px >= x && px <= x + width && py >= y && py <= y + height;
    }
}

class RectangleShape extends Shape {
    public RectangleShape(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        if (selected) {
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, height);
        }
    }
}

class CircleShape extends Shape {
    public CircleShape(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
        if (selected) {
            g.setColor(Color.BLACK);
            g.drawOval(x, y, width, height);
        }
    }
}

class TriangleShape extends Shape {
    public TriangleShape(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int[] xPoints = {x + width / 2, x, x + width};
        int[] yPoints = {y, y + height, y + height};
        g.fillPolygon(xPoints, yPoints, 3);
        if (selected) {
            g.setColor(Color.BLACK);
            g.drawPolygon(xPoints, yPoints, 3);
        }
    }
}
class FreeShape extends Shape {
    ArrayList<Point> points;
    public FreeShape(ArrayList<Point> points, Color color){
        super(0,0,0,0,color);
        this.points = points;
    }
    @Override
    public void draw(Graphics g){
        g.setColor(color);
        for(int i = 1; i < points.size();i++){
            Point p1 = points.get(i - 1);
                        Point p2 = points.get(i);
                        g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
    @Override
    public boolean contains(int px, int py){
        return false;
    }
}