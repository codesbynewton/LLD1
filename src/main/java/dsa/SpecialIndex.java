package dsa;

/*

Problem Statement

Given an array, arr[] of size N, the task is to find the count of array indices
such that removing an element from these indices makes the sum of even-indexed
and odd-indexed array elements equal.

 */

import java.util.Arrays;

public class SpecialIndex {

    public int solve(int[] A) {
        int n = A.length;

        if (n == 0) {
            return 0;
        }

        int[] pfe = new int[n];
        int[] pfo = new int[n];

        pfe[0] = A[0];
        pfo[0] = 0;

        // Calculate prefix even and odd index sums
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                pfe[i] = pfe[i - 1] + A[i];
                pfo[i] = pfo[i - 1];
            } else {
                pfo[i] = pfo[i - 1] + A[i];
                pfe[i] = pfe[i - 1];
            }
        }

        int count = 0;

        // Calculate even and odd sums after removing each element
        for (int i = 0; i < n; i++) {

            int evenSum = i == 0
                    ? pfo[n - 1]
                    : pfe[i - 1] + pfo[n - 1] - pfo[i];

            int oddSum = i == 0
                    ? pfe[n - 1] - pfe[0]
                    : pfo[i - 1] + pfe[n - 1] - pfe[i];

            if (evenSum == oddSum) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        SpecialIndex solution = new SpecialIndex();

        int[] A1 = {2, 1, 6, 4};
        int[] A2 = {1, 1, 1};
        int[] A3 = {5, 5, 2, 5, 8};
        int[] A4 = {1};

        System.out.println("Input: " + Arrays.toString(A1));
        System.out.println("Special Indices: " + solution.solve(A1));

        System.out.println("\nInput: " + Arrays.toString(A2));
        System.out.println("Special Indices: " + solution.solve(A2));

        System.out.println("\nInput: " + Arrays.toString(A3));
        System.out.println("Special Indices: " + solution.solve(A3));

        System.out.println("\nInput: " + Arrays.toString(A4));
        System.out.println("Special Indices: " + solution.solve(A4));
    }
}

