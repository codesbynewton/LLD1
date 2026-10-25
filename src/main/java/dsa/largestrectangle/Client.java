package dsa.largestrectangle;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ArrayList<Integer> A = new ArrayList<>(
                Arrays.asList(2, 1, 5, 6, 2, 3)
        );

        int result = solution.largestRectangleArea(A);

        System.out.println("Largest Rectangle Area: " + result);
    }
}


// Problem Statement

/*
Given an array of integers A.
A represents a histogram i.e A[i] denotes the height of the ith histogram's bar.
Width of each bar is 1.
Find the area of the largest rectangle formed by the histogram.
 */