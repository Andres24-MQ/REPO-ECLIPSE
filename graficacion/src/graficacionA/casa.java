package graficacionA;

import java.awt.*;
import javax.swing.*;

public class casa extends JFrame {
	public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(new Color(5, 229, 245));
        g2d.fillRect(0,0 , 1200, 1000);
        
        // Define el grosor del trazo
        float grosor = 3.0f;
        float grosor2 = 8.0f;
        g2d.setStroke(new BasicStroke(grosor)); 
        //lado izquierdo
        g.setColor(new Color(171, 169, 169));
        g2d.fillRect(100,360,620,435);
        g2d.setStroke(new BasicStroke(grosor2));
        g.setColor(new Color(255,255,255));
        g2d.drawRect(100, 360, 400, 435);
        g.setColor(new Color(252, 252, 240));
        g2d.fillRect(95, 785, 410, 25);
        g.setColor(new Color(255,255,255));
        // buzon
        g2d.fillRect(420, 700, 25, 25);
        g.fillOval(420, 695, 25, 20);
        g.setColor(new Color(240, 240, 240));
        g2d.setStroke(new BasicStroke(grosor)); 
        g2d.drawLine(425, 710, 440, 710);
        g.setColor(new Color(255,255,255));
        //lineas horizontales 
        g2d.drawLine(240, 650, 380, 650);
        g2d.drawLine(240, 720, 380, 720);
        //lineas verticales ventana
        g2d.drawLine(345, 800,345, 760);
        g2d.drawLine(275, 600, 275, 760);
        g2d.setStroke(new BasicStroke(grosor2));
        //puerta de ventana
        g2d.drawRect(240, 600, 140, 180);
        g2d.drawLine(310, 600, 310, 760);
        g2d.drawLine(240, 760, 380, 760);
        //linea del techo
        g2d.drawLine(609, 609, 609, 784);
        g2d.drawLine(50, 570, 500, 570);
        g.setColor(new Color(245, 245, 245));
        g2d.drawLine(60, 578, 500, 578); 
        g.setColor(new Color(240, 240, 240));
        g2d.drawLine(70, 586, 500, 586); 
        g2d.drawLine(75, 594, 500, 594); 
        g.setColor(new Color(135, 135, 135));
        //techo primer piso
        int[] x1Points = {180, 505, 505, 45};
        int[] y1Points = {530, 530, 566, 566};
        g.fillPolygon(x1Points, y1Points, x1Points.length);

        //techo
        int[] xPoints = {140, 1100, 1135, 90};
        int[] yPoints = {105, 105, 358, 358};
        g.fillPolygon(xPoints, yPoints, xPoints.length);
        //triangulo del techo
        int[] x2Points = {110, 300, 490};
        int[] y2Points = {358, 70, 358};
        g.fillPolygon(x2Points, y2Points, x2Points.length);
        g.setColor(new Color(242, 242, 242));
        //lineas internas del techo
        g2d.drawLine(130, 330, 300, 80);
        g2d.drawLine(300, 80, 470, 330);
        //punta del triangulo techo
        int[] x3Points = {250, 300, 350};
        int[] y3Points = {140, 80, 140};
        g.fillPolygon(x3Points, y3Points, x3Points.length);
        //circulo
        g.fillOval(275, 150, 50, 50);
        g.setColor(new Color(232, 232, 232));
        g.fillOval(280, 155, 40, 40);
        //linea debajo del triangulo
        g.setColor(new Color(135, 135, 135));
        g2d.fillRect(120, 320, 360 , 20);
        //lineas exteriores del techo
        g.setColor(new Color(255,255,255));
        g2d.drawLine(100, 360, 300, 70);
        g2d.drawLine(300, 70, 500, 360);

        //Ventana segundo piso
        g.setColor(new Color(232, 232, 232));
        g2d.setStroke(new BasicStroke(grosor)); 
        g2d.drawLine(275, 372, 275, 522);
        g2d.drawLine(345, 372, 345, 522);
        g2d.fillRect(240, 372, 140, 75);
        g2d.drawLine(240, 480, 380, 480);
        g.setColor(new Color(255,255,255));
        g2d.setStroke(new BasicStroke(grosor2));
        g2d.drawRect(240, 372, 140, 150);
        g2d.drawLine(310, 372, 310, 522);
        //pilares
        g.setColor(new Color(240, 240, 240));
        //primer pilar
        g2d.fillRect(70, 588, 15, 210);
        g2d.fillOval(65, 586, 25, 215);
        g2d.fillRect(68, 588, 20, 10);
        g2d.fillRect(65, 790, 25, 20);
        g2d.fillRect(60, 780, 35, 10);
        //segundo pilar
        g2d.fillRect(459, 588, 15, 150);
        g2d.fillOval(454, 586, 25, 155);
        g2d.fillRect(454, 588, 20, 10);
        g2d.fillRect(452, 725, 30,85);
        g2d.drawLine(451, 725, 482, 725);
//segundo lado
        g.setColor(new Color(171, 169, 169));
        g2d.fillRect(500,360,620,435);
        g2d.setStroke(new BasicStroke(grosor2));
        g.setColor(new Color(255,255,255));
        g2d.drawRect(100, 360, 400, 435);
        g.setColor(new Color(252, 252, 240));
        g2d.fillRect(595, 785, 410, 25);
        g.setColor(new Color(255,255,255));
//paredes
        g2d.drawRect(720, 360, 400, 215);
        g2d.drawRect(720, 575, 400, 220);
        
       //ventana inferior
        g2d.drawRect(820, 600, 150, 180);
        g2d.drawLine(870, 380, 870, 522);
        g2d.drawLine(920, 380, 920, 522);
      //ventana superior
        g2d.drawRect(820, 378, 150, 150);
        g2d.drawLine(870, 600, 870, 780);
        g2d.drawLine(920, 600, 920, 780);
        g2d.setStroke(new BasicStroke(grosor2));
      //lineas exteriores del techo x2
        g.setColor(new Color(255,255,255));
        g2d.drawLine(720, 360,920 , 70);
        g2d.drawLine(920, 70, 1120, 360);
        
        //punta del triangulo techo
        int[] x7Points = {870, 920, 970};
        int[] y7Points = {140, 75, 140};
        g.fillPolygon(x7Points, y7Points, x7Points.length);
        //circulo
        g.fillOval(900, 150, 50, 50);
        g.setColor(new Color(232, 232, 232));
        g.fillOval(280, 155, 40, 40);
        //linea medio
        g.drawLine(475, 360, 715, 360);
//puerta 
g2d.drawRect(520, 600, 180, 190);

g2d.drawLine(609, 609, 609, 784);
g2d.drawLine(611, 609, 611, 784);
g2d.fillRect(520, 735, 180, 50);
g2d.setStroke(new BasicStroke(grosor));
g2d.drawLine(565, 600, 565, 760);
g2d.drawLine(657, 600, 657, 760);      
g2d.drawLine(610, 670, 520, 670);
g2d.drawLine(700, 670, 610, 670);
    }
    public static void main(String[] args) throws Exception {
        casa ventana = new casa();
        ventana.setSize(1000,1000);        
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

