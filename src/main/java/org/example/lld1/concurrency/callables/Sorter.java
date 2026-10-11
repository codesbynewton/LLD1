package org.example.lld1.concurrency.callables;

import java.util.concurrent.Callable;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    private List<Integer> arr;
    private ExecutorService executorService;

    public Sorter(List<Integer> arr, ExecutorService executorService){
        this.arr = arr;
        this.executorService = executorService;
    }


    @Override
    public List<Integer> call() throws Exception {
        //base Case
        if(arr.size() <= 1) return arr;

        //calculate mid
        int mid = arr.size()/2;

        //Create two left and right subarrays
        List<Integer> leftArray = arr.subList(0, mid);
        List<Integer> rightArray = arr.subList(mid, arr.size());

        //Create two sorter arrays
        Sorter leftSorter = new Sorter(leftArray, executorService);
        Sorter rightSorter = new Sorter(rightArray, executorService);

        //submit the tasks to the executro to run in parallel
        Future<List<Integer>> leftFuture = executorService.submit(leftSorter);
        Future<List<Integer>> rightFuture = executorService.submit(rightSorter);

        //Wait for both the results
        List<Integer>  sortedLeft = leftFuture.get();
        List<Integer>  sortedRight = rightFuture.get();


        //Merge two sorted arrays
        return merge(sortedLeft, sortedRight);


    }

    private List<Integer> merge(List<Integer> left, List<Integer> right){
        List<Integer> result = new ArrayList<>();

        int i = 0 , j =0;

        while(i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

            while(i < left.size()){
                result.add(left.get(i));
                i++;
            }

            while(j < right.size()){
                result.add(right.get(j));
                j++;
            }

            return result;

    }
}
