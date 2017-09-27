package demo9;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Scanner;

/**
 * Created by Ryan_Garfield on 9/27/17.
 */
public class Processor {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer Thread running...");
            wait();
            System.out.println("Resumed. ");
        }
    }

    public void consume() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this) {
            System.out.println("waiting for return key.");
            scanner.nextLine();
            notify();
            System.out.println("return key pressed");
        }
    }
}
