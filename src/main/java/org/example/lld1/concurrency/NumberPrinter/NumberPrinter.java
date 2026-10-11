package org.example.lld1.concurrency.NumberPrinter;

public class NumberPrinter implements Runnable{

    private int numberToPrint;

    public NumberPrinter(int numberToPrint){
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run(){
        System.out.println("The number is " + numberToPrint + " And the Thread is " + Thread.currentThread());
    }

}
