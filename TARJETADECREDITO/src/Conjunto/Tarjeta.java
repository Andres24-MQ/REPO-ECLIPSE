package Conjunto;

import javax.swing.*;

import org.w3c.dom.css.RGBColor;

import java.awt.*;
import java.awt.event.*;

public class Tarjeta extends JFrame {
    private JTextField[] campos = new JTextField[19];
    private JPanel panel;
    private JLabel titulo;

    public Tarjeta() {
        setTitle("Ingreso de Tarjeta de Crédito");
        setSize(600, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(Color.RED);
        setLayout(new BorderLayout());

        titulo = new JLabel("POR FAVOR INGRESA UN NUMERO DE TARJETA...", SwingConstants.CENTER);
        titulo.setFont(new Font("Sans-serif", Font.BOLD,16));
        titulo.setForeground(Color.WHITE);
        
        JPanel contenedor = new JPanel();
        contenedor.setOpaque(false);

        panel = new JPanel();
        panel.setOpaque(false);

        for (int i = 0; i < 19; i++) {
            if (i == 4 || i == 9 || i == 14) {
                JLabel guion = new JLabel("-");
                guion.setFont(new Font("Sans-serif", Font.BOLD, 18));
                guion.setForeground(Color.WHITE);
                panel.add(guion);

            } else {
                campos[i] = new JTextField(1);
                campos[i].setHorizontalAlignment(JTextField.CENTER);
                campos[i].setFont(new Font("Sans-serif", Font.BOLD, 16));
                campos[i].setPreferredSize(new Dimension(40, 40));
                

                campos[i].addKeyListener(new KeyAdapter() {
                    //pisa la tecla
                    public void keyTyped(KeyEvent e) {
                        int c = e.getKeyChar();
                        if (!Character.isDigit(c) || ((JTextField) e.getSource()).getText().length() >= 1) {
                            e.consume();
                        }
                    }
                
                    //suelta la tecla
                    public void keyReleased(KeyEvent e) {
                        validarEntrada();
                    }
                });

                panel.add(campos[i]);
            }
        }

        contenedor.add(panel);
        add(contenedor, BorderLayout.CENTER);
        add(titulo, BorderLayout.NORTH);
    }


    private void validarEntrada() {
        boolean esValido = true;
        int digitCount = 0;

        for (JTextField campo : campos) {
            if (campo != null && campo.getText().length() == 1) {
                digitCount++;
            }
        }

        if (digitCount != 16) {
            esValido = false;
        }

        getContentPane().setBackground(esValido ? Color.GREEN : Color.RED);
        titulo.setForeground(esValido ? Color.BLACK : Color.WHITE);
        repaint();
    }

    public static void main(String[] args) {
        new Tarjeta().setVisible(true);
    }
}
