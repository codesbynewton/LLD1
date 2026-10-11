package org.example.lld1.concurrency.HelloWorldPrinter;

public class HelloWorldPrinter implements Runnable{
    @Override
    public void run() {
        for(int i= 0; i < 5; i++){
            System.out.println(Thread.currentThread() +  "Hello World");
        }

        helperMethod();
    }

    public void helperMethod(){
        System.out.println("The helper method");
    }


}
