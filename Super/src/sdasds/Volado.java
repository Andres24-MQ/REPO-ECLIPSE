package sdasds;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Volado {
    public static void main(String[] args) {
        int DineroInicial = 30;
        int Objetivo = 50;
        int TotalS = 200;
        int SimulacionesExitosas = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("¿Prefieres águila o sello? ");
        String eleccion = scanner.nextLine();

        while (!eleccion.equals("aguila") && !eleccion.equals("sello")) {      
            eleccion = scanner.nextLine();
        }

        double Iaguila = 0.0;
        double Faguila = 0.49;
        double ISello = 0.50;
        double Fsello = 0.99;

        List<String[]> DatosSimulacion = new ArrayList<>();

        for (int i = 0; i < TotalS; i++) {
            int DineroActual = DineroInicial;
            List<String> GuardadoDeApuesta = new ArrayList<>();

            // Datos iniciales
            GuardadoDeApuesta.add(String.valueOf(i + 1)); // Número de simulación
            GuardadoDeApuesta.add(String.valueOf(DineroActual)); // Dinero antes del volado
            GuardadoDeApuesta.add("10"); // MontoApuesta

            // Generar número aleatorio dentro del rango
            double randomNumber = random.nextDouble();
            GuardadoDeApuesta.add(String.valueOf(randomNumber)); // Número aleatorio generado

            // Determinar el resultado
            int SoA;
            String result;
            if (randomNumber >= Iaguila && randomNumber <= Faguila) {
                SoA = 0; // Águila
                result = eleccion.equals("aguila") ? "Si" : "No";
            } else {
                SoA = 1; // Sello
                result = eleccion.equals("sello") ? "Sí" : "No";
            }
            GuardadoDeApuesta.add(result); // Si ganó o no

            // Volado
            if (SoA == 0) { // Si fue águila
                DineroActual += 20; // Duplicar la apuesta
            }

            // Datos después del volado
            GuardadoDeApuesta.add(String.valueOf(DineroActual)); // Dinero después del volado

            // Verificar si alcanzó la meta o quedó sin dinero
            if (DineroActual >= Objetivo) {
                SimulacionesExitosas++;
                GuardadoDeApuesta.add("Sí"); // Alcanzó la meta
            } else {
            	GuardadoDeApuesta.add("No"); // No alcanzó la meta
            }

            DatosSimulacion.add(GuardadoDeApuesta.toArray(new String[0]));
        }

        // Imprimir la tabla
        System.out.println("Simulación\tDinero antes\tApuesta\tAleatorio\tResultado\tDinero después\tAlcanzó la meta");
        for (String[] row : DatosSimulacion) {
            for (String cell : row) {
                System.out.print(cell + "\t\t");
            }
            System.out.println();
        }

        double Proba = (double) SimulacionesExitosas / TotalS * 100;
        System.out.println("\nProbabilidad de alcanzar la meta: " + Proba + "%");

        scanner.close();
    }
}

