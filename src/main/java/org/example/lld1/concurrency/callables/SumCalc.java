package org.example.lld1.concurrency.callables;

import java.util.concurrent.Callable;

public class SumCalc implements Callable<Integer> {
    private int number;

    public SumCalc(int number){
        this.number = number;
    }

    @Override
    public Integer call(){
        int sum = 0;
        for(int i = 0; i <= number; i++){
            sum += i;
        }

        return sum;
    }

}
