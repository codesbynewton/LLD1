package dsa;


import java.util.Arrays;

public class FindMissingInteger {

    public int firstMissingPositive(int[] A) {
        int n = A.length;

        // Step 1: Replace non-positive numbers and numbers > n
        // with n + 1
        for (int i = 0; i < n; i++) {
            if (A[i] <= 0 || A[i] > n) {
                A[i] = n + 1;
            }
        }

        // Step 2: Mark numbers that exist in the range [1, n]
        for (int i = 0; i < n; i++) {
            int value = Math.abs(A[i]);

            if (value >= 1 && value <= n) {
                int index = value - 1;
                A[index] = -Math.abs(A[index]);
            }
        }

        // Step 3: Find the first positive position
        for (int i = 0; i < n; i++) {
            if (A[i] > 0) {
                return i + 1;
            }
        }

        // All numbers from 1 to n exist
        return n + 1;
    }

    public static void main(String[] args) {
        FindMissingInteger solution = new FindMissingInteger();

        int[][] testCases = {
                {1, 2, 0},
                {3, 4, -1, 1},
                {7, 8, 9, 11, 12},
                {1, 2, 3, 4, 5},
                {-1, -2, 0},
                {2, 2, 1, 1},
                {1},
                {2}
        };

        for (int[] testCase : testCases) {
            System.out.println("Input: " + Arrays.toString(testCase));

            int result = solution.firstMissingPositive(testCase);

            System.out.println("First missing positive: " + result);
            System.out.println();
        }
    }
}
