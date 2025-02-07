package sdasds;

import java.util.*;

public class BLACKJACK {
    private static final Map<String, Integer> BARAJA = new HashMap<>();
    static {
        BARAJA.put("2", 2);
        BARAJA.put("3", 3);
        BARAJA.put("4", 4);
        BARAJA.put("5", 5);
        BARAJA.put("6", 6);
        BARAJA.put("7", 7);
        BARAJA.put("8", 8);
        BARAJA.put("9", 9);
        BARAJA.put("10", 10);
        BARAJA.put("J", 10);
        BARAJA.put("Q", 10);
        BARAJA.put("K", 10);
        BARAJA.put("A", 11);
    }

    private static int calcularValorMano(List<String> mano) {
        int valor = 0;
        for (String carta : mano) {
            valor += BARAJA.get(carta);
        }
        // Considerar el valor del As
        for (String carta : mano) {
            if (carta.equals("A") && valor > 21) {
                valor -= 10;
            }
        }
        return valor;
    }

    private static void jugarBlackjack(List<String> cartas, List<List<String>> jugadores, Scanner scanner) {
        // Repartir cartas a todos los jugadores incluyendo el crupier
        for (List<String> jugador : jugadores) {
            jugador.add(cartas.remove(new Random().nextInt(cartas.size())));
            jugador.add(cartas.remove(new Random().nextInt(cartas.size())));
        }

        // Pedir carta a cada jugador
        for (int i = 0; i < jugadores.size(); i++) {
            List<String> jugador = jugadores.get(i);
            System.out.println("Mano del Jugador " + (i + 1) + ": " + jugador);
            while (true) {
                System.out.print("¿Jugador " + (i + 1) + ", ¿quieres otra carta? (si/no): ");
                String respuesta = scanner.nextLine().trim().toLowerCase();
                if (respuesta.equals("si")) {
                    jugador.add(cartas.remove(new Random().nextInt(cartas.size())));
                    System.out.println("Mano del Jugador " + (i + 1) + ": " + jugador);
                } if (respuesta.equals("no")) {
					break;
				} 
                   
                
            }
        }

        // Jugar el turno del crupier
        List<String> crupier = jugadores.get(jugadores.size() - 1);
        while (calcularValorMano(crupier) < 17) {
            crupier.add(cartas.remove(new Random().nextInt(cartas.size())));
        }

        // Mostrar manos finales
        System.out.println("Mano del Crupier: " + crupier);
    }

    private static void monteCarloBlackjack(int simulaciones, Scanner scanner, int numJugadores) {
        Map<String, Integer> resultados = new HashMap<>();
        resultados.put("Ganaste", 0);
        resultados.put("Perdiste", 0);
        resultados.put("Empate", 0);

        List<String> cartas = new ArrayList<>(BARAJA.keySet());
        List<List<String>> jugadores = new ArrayList<>();
        for (int i = 0; i <= numJugadores; i++) {
            jugadores.add(new ArrayList<>());
        }

        for (int i = 0; i < simulaciones; i++) {
            jugarBlackjack(new ArrayList<>(cartas), jugadores, scanner);

            // Determinar el resultado
            int valorJugador = calcularValorMano(jugadores.get(0));
            int valorCrupier = calcularValorMano(jugadores.get(jugadores.size() - 1));
            for (int j = 0; j < jugadores.size() - 1; j++) {
                int valorJugadorActual = calcularValorMano(jugadores.get(j));
                if (valorJugadorActual <= 21 && (valorJugadorActual > valorCrupier || valorCrupier > 21)) {
                    valorJugador = valorJugadorActual;
                }
            }
            if (valorJugador > 21) {
                resultados.put("Perdiste", resultados.get("Perdiste") + 1);
            } else if (valorCrupier > 21 || valorJugador > valorCrupier) {
                resultados.put("Ganaste", resultados.get("Ganaste") + 1);
            } else if (valorJugador == valorCrupier) {
                resultados.put("Empate", resultados.get("Empate") + 1);
            } else {
                resultados.put("Perdiste", resultados.get("Perdiste") + 1);
            }
        }

        System.out.println("\nResultados de las simulaciones:");
        for (Map.Entry<String, Integer> entry : resultados.entrySet()) {
            double porcentaje = (double) entry.getValue() / simulaciones * 100;
            System.out.printf("%s: %d (%.2f%%)%n", entry.getKey(), entry.getValue(), porcentaje);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al juego de Blackjack con el método de Monte Carlo.");

        System.out.print("¿Cuántas simulaciones quieres realizar?: ");
        int simulaciones = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        System.out.print("¿Cuántos jugadores van a jugar? (Máximo 4): ");
        int numJugadores = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (numJugadores <= 0 || numJugadores >= 4) {
            System.out.println("Número de jugadores no válido.");
            return;
        }

        monteCarloBlackjack(simulaciones, scanner, numJugadores);
        scanner.close();
    }
}

