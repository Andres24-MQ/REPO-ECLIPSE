package sdasds;

import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.*;
public class borracho extends JPanel {
    private List<int[][]> todasLasCoordenadas = new ArrayList<>();
    private Color[] colores = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE,Color.MAGENTA,Color.cyan,Color.pink};
    private int colorActual = 0;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new borracho());
        frame.setVisible(true);
    }
    public borracho(){
        DecimalFormat df = new DecimalFormat("#.########");
        double P=0, Exito=0;
        Scanner sc =new Scanner(System.in);
        System.out.println("Cuantas simulaciones quieres hacer?");
        double Veces=sc.nextDouble();
        char PC=' ';
        System.out.print("N\t#AleaGen\tPC\tPosicion");
        System.out.println();
        for(int v=0;v<Veces;v++){
            int x=0,y=0;  // Reinicia las coordenadas al inicio de cada simulación
            int[][] coordenadas = new int[11][2];  // Reinicia el arreglo de coordenadas
            coordenadas[0][0] = x;
            coordenadas[0][1] = y; 
            System.out.print("0\t-\t\t-\t("+0+","+0+")");
            System.out.println();
            for(int i=1;i<=10;i++){
                double random=Math.random();
                if(random<=0.25){
                    y += 1;
                    PC='N';
                }else if(random<=0.50){
                    y -= 1;
                    PC='S';
                }else if(random<=0.75){
                    x += 1;
                    PC='E';
                }else{
                    x -= 1;
                    PC='O';
                }
                coordenadas[i][0] = x;
                coordenadas[i][1] = y; 
                System.out.print(i+"\t"+df.format(random)+"\t"+PC+"\t("+x+","+y+")");
                System.out.println();
                if(i==9){
                    int Suma=Math.abs(x)+Math.abs(y);
                    if(Suma>2){
                        Exito++;
                    }
                }
            }
            todasLasCoordenadas.add(coordenadas);  // Almacena las coordenadas de esta simulación
        }
        P=Exito/Veces;
        System.out.println("Promedio que quede a mas de 2 cuadras es: "+P);
    }

    @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.translate(getWidth() / 2, getHeight() / 2);  // Centra el origen (0,0) en el medio de la ventana

    // Dibuja las líneas de cuadrícula
    g.setColor(Color.LIGHT_GRAY);
    for (int i = -getWidth() / 2; i <= getWidth() / 2; i += 30) {
        g.drawLine(i, -getHeight() / 2, i, getHeight() / 2);
        g.drawLine(-getWidth() / 2, i, getWidth() / 2, i);
    }

    // Dibuja los ejes
    g.setColor(Color.BLACK);
    g.drawLine(-getWidth() / 2, 0, getWidth() / 2, 0);  // Eje X
    g.drawLine(0, -getHeight() / 2, 0, getHeight() / 2);  // Eje Y

    // Dibuja las etiquetas de los ejes
    for (int i = -10; i <= 10; i++) {
        g.drawString(Integer.toString(i), i * 30, 0);
        g.drawString(Integer.toString(-i), 0, i * 30);
    }

    // Dibuja los puntos y las líneas de todas las simulaciones
    int scale = 30;  // Define cuántos píxeles corresponden a una unidad en el plano cartesiano
    for (int[][] coordenadas : todasLasCoordenadas) {
        g.setColor(colores[colorActual]);
        for (int i = 0; i < coordenadas.length - 1; i++) {
            int x1 = coordenadas[i][0] * scale;
            int y1 = -coordenadas[i][1] * scale;  // Invierte el eje Y porque en la pantalla el eje Y va hacia abajo
            int x2 = coordenadas[i + 1][0] * scale;
            int y2 = -coordenadas[i + 1][1] * scale;
            g.drawLine(x1, y1, x2, y2);
            g.fillOval(x1 - 5, y1 - 5, 10, 10);  // Dibuja un círculo en cada punto
        }
        // Dibuja un círculo en el último punto
        int x = coordenadas[coordenadas.length - 1][0] * scale;
        int y = -coordenadas[coordenadas.length - 1][1] * scale;
        g.fillOval(x - 5, y - 5, 10, 10);

        if(colorActual<(colores.length-1)){
            colorActual++;        
        }else{
            colorActual=0;
        }
    }
}

}
