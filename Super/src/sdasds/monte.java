package sdasds;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class monte {

    public static Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("----BIENVENIDO AL PROGRAMA GENERADOR DE SECUENCIAS----");

        System.out.println("Introduzca la semilla: (máximo 3 dígitos) ");
        int Psemilla = tec.nextInt();
        if (Psemilla >= 1000) {
            System.out.println("Semilla no válida");

        } else {
            pseudoaletorios(Psemilla);
        }
    }

    public static void pseudoaletorios(int Semilla) {
        int exp = 0, num1 = 0, cont = 0;
        double media = 0.0, varianza = 0.0;
        Set<Integer> numerosGenerados = new HashSet<>();
        System.out.println("|NUMERO\t--SEMILLA\t--SEMILLA^2\t--NUMseleccionado\t--NUMEROsig\t|");

        do {
            cont++;
            exp = (int) Math.pow(Semilla, 2);
            String num1s = String.valueOf(exp);
            if (num1s.length() < 5) {
                do {
                    num1s = "0" + num1s;
                } while (num1s.length() <= 4);
                num1 = Integer.parseInt(num1s.substring(1, 4));
            }
            if (num1s.length() == 5) {
                num1 = Integer.parseInt(num1s.substring(1, 4));
            }
            if (num1s.length() == 6) {
                num1s = "0" + num1s;
                num1 = Integer.parseInt(num1s.substring(2, 5));
            }

            if (numerosGenerados.contains(num1)) {
                System.out.println("Número repetido encontrado: " + num1);
                break;
            }
            numerosGenerados.add(num1);
            media += num1; // Sumar el número para calcular la media
            System.out.println("|" + cont + "\t|" + Semilla + "\t\t|" + exp + "\t\t|" + num1 + "\t\t|" + num1
                    + "\t\t|");
            Semilla = num1;
        } while (num1 != 0 || num1 != Semilla);
        System.out.println("|__|_____|_____|_____|______|");

      
        media /= cont;


        for (int num : numerosGenerados) {
            varianza += Math.pow(num - media, 2);
        }
        varianza /= cont;

        System.out.println("Media de la secuencia: " + media);
        System.out.println("Varianza de la secuencia: " + varianza);
    }
}
