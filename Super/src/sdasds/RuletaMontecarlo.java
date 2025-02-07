package sdasds;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RuletaMontecarlo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la ruleta de Montecarlo!");
        List<String> ruleta = crearRuleta(scanner);
        
        System.out.println("Presione Enter para girar la ruleta...");
        scanner.nextLine();
        
        String resultado = girarRuleta(ruleta);
        System.out.println("La ruleta ha caído en: " + resultado);
        
        scanner.close();
       
    }

    public static List<String> crearRuleta(Scanner scanner) {
        System.out.print("¿Cuántas divisiones desea en la ruleta?: ");
        int divisiones = Integer.parseInt(scanner.nextLine()); 
        
        List<String> ruleta = new ArrayList<>();
        for (int i = 0; i < divisiones; i++) {
            System.out.print("Ingrese la información para la división " + (i + 1) + ": ");
            String informacion = scanner.nextLine();
            ruleta.add(informacion);
        }
        return ruleta;
    }

    public static String girarRuleta(List<String> ruleta) {
        Random random = new Random();
        int indice = random.nextInt(ruleta.size());
        return ruleta.get(indice);
    }
}
