import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Taquilla {
    private final BlockingQueue<Integer> boletos;
    private static final ReentrantLock lockPrint = new ReentrantLock(); 

    public Taquilla(int cantidadBoletos) {
        boletos = new ArrayBlockingQueue<>(cantidadBoletos);
        for (int i = 1; i <= cantidadBoletos; i++) {
            boletos.add(i);
        }
    }

    public int venderBoleto(int clienteId) throws InterruptedException {
        int boleto = boletos.take();
        lockPrint.lock();
        try {
            System.out.println("El cliente " + clienteId + " compró el siguiente N* de boleto: " + boleto);
        } finally {
            lockPrint.unlock();
        }
        Thread.sleep(600);
        return boleto;
    }

    public void devolverBoleto(int clienteId, int boleto, boolean usado) throws InterruptedException {
        if (usado) {
            lockPrint.lock();
            try {
                System.out.println("El cliente " + clienteId + " utilizo el boleto N*: " + boleto);
            } finally {
                Thread.sleep(600);
                lockPrint.unlock();
            }
        } else {
            boletos.put(boleto);
            lockPrint.lock();
            try {
                System.out.println("El cliente " + clienteId + " regreso el boleto N*: " + boleto);
            } finally {
                Thread.sleep(600);
                lockPrint.unlock();
            }
        }
    }

    public int boletosDisponibles() {
        return boletos.size();
    }
}
