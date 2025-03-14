public class App {
    public static void main(String[] args) throws Exception {
        Tarea1 H1 = new Tarea1();
        Tarea2 H2 = new Tarea2();
        Tarea3 H3 = new Tarea3();
        Thread t1 = new Thread(H1);
        Thread t2 = new Thread(H2);
        Thread t3 = new Thread(H3);
        t1.start();
        t2.start();
        t3.start();

        //checar si uno o mas hilos estan activos
        while (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
        }
    }
}
