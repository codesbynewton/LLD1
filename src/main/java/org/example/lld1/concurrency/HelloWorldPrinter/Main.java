package org.example.lld1.concurrency.HelloWorldPrinter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi from main thread");

        // Step 1 : Actual instance of our task
        HelloWorldPrinter hp = new HelloWorldPrinter();

        //Step 2 : Create a thread and give it your task
        Thread thread = new Thread(hp);

        // Step 3 :  Start your thread
        thread.start(); // <- this creates a new thread and starts executes it


        System.out.println("Main thread continues" + Thread.currentThread());

        //thread.run() -> just calls the run method in the current(main) thread
        //thread.start() -> creates a new thread and the os schedules a new thread

    }
}
