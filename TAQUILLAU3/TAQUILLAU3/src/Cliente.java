public class Cliente extends Thread {
    private final int id;
    private final Taquilla taquilla;

    public Cliente(int id, Taquilla taquilla) {
        this.id = id;
        this.taquilla = taquilla;
    }

    @Override
    public void run() {
        try {
            int boleto = taquilla.venderBoleto(id);

            boolean UsoBoleto = Math.random() < 0.5;

            taquilla.devolverBoleto(id, boleto, UsoBoleto);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
