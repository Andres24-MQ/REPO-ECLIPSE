public class IncrementsA extends Thread {
    private static int A = 0;
    public void run(){
        A++;
    }
    public String toString(){
        return A+ " ";
    }
}
