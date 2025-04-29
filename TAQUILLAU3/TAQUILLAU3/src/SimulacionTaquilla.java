public class SimulacionTaquilla {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Bienvenido, iniciando simulacion....");
        Thread.sleep(1500);

        System.out.println("--------------------------------------------------");
        Taquilla taquilla = new Taquilla(10);

        Cliente[] clientes = new Cliente[15];

        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(i + 1, taquilla);
            clientes[i].start();
        }

        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Boletos restantes en la taquilla: " + taquilla.boletosDisponibles());
        System.out.println("--------------------------------------------------");
        System.out.println("Fin de la simulacion");
    }
}
