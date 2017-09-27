package demo14;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Ryan_Garfield on 9/27/17.
 */
public class Thread14 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> future = executor.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);

                if (duration > 200) {
                    throw new IOException("Sleeping to long");
                }
                System.out.println("Staring...");

                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Finished.");
                return duration;
            }
        });

        executor.shutdown();

        try {
            System.out.println("Result is: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
