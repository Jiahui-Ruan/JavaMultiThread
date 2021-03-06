package demo11;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ryan_Garfield on 9/27/17.
 */
public class Runner {

    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }
    public void firstThread() throws InterruptedException {
        lock.lock();
        System.out.println("waiting...");
        cond.await();

        System.out.println("wake up");
        increment();
        lock.unlock();
    }

    public void secondThread() throws InterruptedException {
        Thread.sleep(1000);
        lock.lock();

        System.out.println("press the return key");
        new Scanner(System.in).nextLine();
        System.out.println("got return key!");

        cond.signal();

        increment();
        lock.unlock();
    }

    public void finished() {
        System.out.println("count is: " + count);
    }
}
