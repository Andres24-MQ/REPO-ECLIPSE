package MultiHilos;

public class HiloContador extends Thread{
    private Contador contador;
    private String nombreHilo;
    private int limite;

    public HiloContador(Contador contador, String nombreHilo,  int limite){

    this.contador = contador;
    this.nombreHilo = nombreHilo;
    this.limite = limite;
    }

    @Override
    public void run() {
        contador.incrementar(nombreHilo, limite);
    }

}
