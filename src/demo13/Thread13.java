package demo13;

import java.util.concurrent.Semaphore;

/**
 * Created by Ryan_Garfield on 9/27/17.
 */
public class Thread13 {
    public static void main(String[] args) throws Exception{
        Semaphore sem = new Semaphore(1);

        sem.acquire();

        System.out.println("Avaiable permits: " + sem.availablePermits());
    }
}
