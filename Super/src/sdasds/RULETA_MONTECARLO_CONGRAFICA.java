package sdasds;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RULETA_MONTECARLO_CONGRAFICA extends JPanel {
    private List<String> ruleta;
    private String resultado;
    private double angulo;
    private double anguloInicial;
    private boolean girando;

    public RULETA_MONTECARLO_CONGRAFICA(List<String> ruleta) {
        this.ruleta = ruleta;
        this.resultado = "";
        this.angulo = 0;
        this.anguloInicial = 0;
        this.girando = false;
    }

    public void girarRuleta() {
        if (!girando) {
            Random random = new Random();
            int indice = random.nextInt(ruleta.size());
            resultado = ruleta.get(indice);
            anguloInicial = angulo % 360;
            double anguloFinal = anguloInicial + 1080 + random.nextDouble() * 360; // Entre 1080 y 1440 grados de rotación
            animarGiro(anguloFinal);
        }
    }

    private void animarGiro(double anguloFinal) {
        girando = true;
        Timer timer = new Timer(15, null);
        timer.addActionListener(e -> {
            angulo += 5;
            if (angulo >= anguloFinal) {
                ((Timer) e.getSource()).stop();
                girando = false;
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        int radius = Math.min(width, height) / 3;

        // Dibuja la ruleta
        g2d.setColor(Color.BLACK);
        g2d.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

        g2d.setColor(Color.WHITE);
        g2d.fillOval(centerX - radius + 10, centerY - radius + 10, 2 * radius - 20, 2 * radius - 20);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));

        int numDivisions = ruleta.size();
        double angle = 2 * Math.PI / numDivisions;
        for (int i = 0; i < numDivisions; i++) {
            double theta = i * angle - Math.PI / 2 + Math.toRadians(angulo);
            int x = (int) (centerX + radius * Math.cos(theta));
            int y = (int) (centerY + radius * Math.sin(theta));
            g2d.drawLine(centerX, centerY, x, y);

            String text = ruleta.get(i);
            // Coloca el texto centrado en la división
            int textX = (int) (centerX + (radius * 0.8) * Math.cos(theta - angle / 2));
            int textY = (int) (centerY + (radius * 0.8) * Math.sin(theta - angle / 2));
            drawRotatedString(g2d, text, textX, textY, Math.toDegrees(theta) - 90);
        }

        // Muestra el resultado seleccionado
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Arial", Font.BOLD, 18));
        g2d.drawString("Resultado: " + resultado, centerX - 70, centerY + radius + 30);
    }

    // Método para dibujar texto rotado
    private void drawRotatedString(Graphics2D g2d, String text, int x, int y, double angleDegrees) {
        g2d.translate(x, y);
        g2d.rotate(Math.toRadians(angleDegrees));
        g2d.drawString(text, -g2d.getFontMetrics().stringWidth(text) / 2, g2d.getFontMetrics().getHeight() / 2);
        g2d.rotate(-Math.toRadians(angleDegrees));
        g2d.translate(-x, -y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la ruleta de Montecarlo!");
        List<String> ruleta = crearRuleta(scanner);

        RULETA_MONTECARLO_CONGRAFICA ruletaMontecarlo = new RULETA_MONTECARLO_CONGRAFICA(ruleta);

        JFrame frame = new JFrame("Ruleta de Montecarlo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(ruletaMontecarlo);
        frame.setVisible(true);

        System.out.println("Presiona Enter para girar la ruleta...");
        scanner.nextLine();
        ruletaMontecarlo.girarRuleta();

        scanner.close();
    }

    public static List<String> crearRuleta(Scanner scanner) {
        System.out.print("¿Cuántas divisiones tiene la ruleta?: ");
        int divisiones = Integer.parseInt(scanner.nextLine());

        List<String> ruleta = new ArrayList<>();
        for (int i = 0; i < divisiones; i++) {
            System.out.print("Ingrese los datos para la division " + (i + 1) + ": ");
            String informacion = scanner.nextLine();
            ruleta.add(informacion);
        }
        return ruleta;
    }
}