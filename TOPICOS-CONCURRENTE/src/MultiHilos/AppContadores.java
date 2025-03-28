package MultiHilos;

public class AppContadores {
    public static void main(String[] args){
        Contador contador = new Contador();

        HiloContador hilo1 = new HiloContador(contador, "Hilo 1", 5);
        HiloContador hilo2 = new HiloContador(contador, "Hilo 2", 10);

        hilo1.start();
        hilo2.start();
    }
}
