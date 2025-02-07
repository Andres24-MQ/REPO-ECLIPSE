package sdasds;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MiMontecarlo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> opciones = new ArrayList<>();
        opciones.add("Falla de motor");
        opciones.add("Alta temperatura");
        opciones.add("Falla de frenos");
        opciones.add("Falta de combustible");

        List<Integer> votos = new ArrayList<>();
        votos.add(45);
        votos.add(23);
        votos.add(19);
        votos.add(13);

        System.out.println("Bienvenido al simulador de fallas de carros de Formula 1!");

        System.out.print("¿Cuántas simulaciones desea realizar?: ");
        int simulaciones = Integer.parseInt(scanner.nextLine());

        // Mapa para mantener el recuento de cada resultado
        Map<String, Integer> recuentoResultados = new HashMap<>();
        for (String opcion : opciones) {
            recuentoResultados.put(opcion, 0);
        }

        // Realizar las simulaciones
        for (int i = 1; i <= simulaciones; i++) {
            List<String> ruleta = crearRuleta(opciones, votos);
            String resultado = girarRuleta(ruleta);
            System.out.println("Simulación #" + i + ": La razón de la falla del carro de Formula 1 es: " + resultado);
            
            // Actualizar el recuento del resultado actual
            recuentoResultados.put(resultado, recuentoResultados.get(resultado) + 1);
        }

        // Calcular y mostrar los porcentajes de los resultados
        System.out.println("\nPorcentaje de veces que cada resultado ocurrió:");
        for (String opcion : opciones) {
            double porcentaje = (double) recuentoResultados.get(opcion) / simulaciones * 100;
            System.out.println(opcion + ": " + String.format("%.2f", porcentaje) + "%");
        }

        scanner.close();
    }

    public static List<String> crearRuleta(List<String> opciones, List<Integer> votos) {
        List<String> ruleta = new ArrayList<>();

        // Agregar cada opción a la ruleta con una cantidad de veces proporcional a sus votos
        for (int i = 0; i < opciones.size(); i++) {
            for (int j = 0; j < votos.get(i); j++) {
                ruleta.add(opciones.get(i));
            }
        }
        return ruleta;
    }

    public static String girarRuleta(List<String> ruleta) {
        Random random = new Random();

        // Generar un número aleatorio entre 0 y el tamaño de la ruleta
        int indice = random.nextInt(ruleta.size());

        // Seleccionar la opción correspondiente al índice aleatorio
        return ruleta.get(indice);
    }
}

