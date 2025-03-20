package paquete1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {
    private JTextField display;
    private String operador = "";
    private double num1, num2, resultado;

    public Calculadora() {
        setTitle("Calculadora De Andres Ochoa");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        display = new JTextField();
        display.setBounds(10, 20, 260, 45); 
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 4, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10)); 
        panelBotones.setBounds(0, 80, 290, 230); 
        panelBotones.setBackground(new Color(165, 185, 187));

        String[] botones = {
            "C", "CE", "MOD", "+/-", 
            "7", "8", "9", "+", 
            "4", "5", "6", "-", 
            "1", "2", "3", "*", 
            "0", ".", "=", "/"
        };

        for (String botonTexto : botones) {
            JButton boton = new JButton(botonTexto);
            boton.addActionListener(this);
            panelBotones.add(boton);
        }
        add(panelBotones);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.matches("[0-9]")) { 
            display.setText(display.getText() + comando);
        
        } else if (comando.equals(".")) {
            if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }

        } else if (comando.equals("C")) {
            display.setText("");

        } else if (comando.equals("CE")) {
            if (!display.getText().isEmpty()) {
                display.setText(display.getText().substring(0, display.getText().length() - 1));
            }

        } else if (comando.equals("+/-")) {
            if (!display.getText().isEmpty()) {
                double num = Double.parseDouble(display.getText()) * -1;
                display.setText(String.valueOf(num));
            }

        } else if (comando.equals("MOD")) {
            operador = "MOD";
            num1 = Double.parseDouble(display.getText());
            display.setText("");

        } else if (comando.equals("+") || comando.equals("-") || comando.equals("*") || comando.equals("/")) {
            operador = comando;
            num1 = Double.parseDouble(display.getText());
            display.setText("");

        } else if (comando.equals("=")) {
            num2 = Double.parseDouble(display.getText());

            switch (operador) {
                case "+": resultado = num1 + num2; 
                break;
                case "-": resultado = num1 - num2; 
                break;
                case "*": resultado = num1 * num2; 
                break;
                case "/": resultado = num2 != 0 ? num1 / num2 : 0;
                break;
                case "MOD": resultado = num1 % num2;
                break;
            }

            display.setText(String.valueOf(resultado));
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}
