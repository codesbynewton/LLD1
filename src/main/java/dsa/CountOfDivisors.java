package dsa;

/*
Given an array of integers A,
 find and return the count of divisors of each element of the array.

NOTE: The order of the resultant array should be the same as the input array.
 */



import java.util.Arrays;
import java.util.Scanner;

public class CountOfDivisors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        CountOfDivisors solution = new CountOfDivisors();
        int[] result = solution.solve(A);

        System.out.println(Arrays.toString(result));

        sc.close();
    }

    public int[] solve(int[] A) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }

        int[] ans = new int[max];

        for (int i = 0; i < max; i++) {
            for (int j = i; j < max; j += (i + 1)) {
                ans[j]++;
            }
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = ans[A[i] - 1];
        }

        return A;
    }
}