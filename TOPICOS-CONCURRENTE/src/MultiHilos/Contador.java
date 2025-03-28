package MultiHilos;

public class Contador {
    private int valor = 0;
    
    public synchronized void incrementar(String nombreHilo, int limite){
        for (int i = 1; i < limite; i++) {
            valor ++;
            System.out.println(nombreHilo + " incrementa el contador a: " + valor);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

