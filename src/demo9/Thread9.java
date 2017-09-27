package demo9;

/**
 * Created by Ryan_Garfield on 9/27/17.
 */
public class Thread9 {
    public static void main(String[] args) throws InterruptedException{
        final Processor processor = new Processor();
        Thread t1 = new Thread(() -> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
