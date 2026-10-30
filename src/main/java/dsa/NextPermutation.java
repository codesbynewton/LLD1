package dsa;

import java.util.Arrays;

public class NextPermutation {

    private int[] reverseArray(int[] arr, int left, int right) {
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;

            left++;
            right--;
        }

        return arr;
    }

    public int[] nextPermutation(int[] A) {
        int n = A.length;
        int idx = -1;

        // Step 1: Find the first decreasing element from the right
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                idx = i;
                break;
            }
        }

        // Step 2: If no such element exists, reverse the entire array
        if (idx == -1) {
            return reverseArray(A, 0, n - 1);
        }

        // Step 3: Find the next greater element from the right
        for (int i = n - 1; i > idx; i--) {
            if (A[idx] < A[i]) {
                int tmp = A[idx];
                A[idx] = A[i];
                A[i] = tmp;
                break;
            }
        }

        // Step 4: Reverse the suffix
        return reverseArray(A, idx + 1, n - 1);
    }

    public static void main(String[] args) {

        NextPermutation solution = new NextPermutation();

        int[] A1 = {1, 2, 3};
        int[] A2 = {3, 2, 1};
        int[] A3 = {1, 1, 5};
        int[] A4 = {1, 3, 2};
        int[] A5 = {2, 3, 1, 4};

        System.out.println("Input: " + Arrays.toString(A1));
        System.out.println("Next Permutation: " +
                Arrays.toString(solution.nextPermutation(A1)));

        System.out.println("\nInput: " + Arrays.toString(A2));
        System.out.println("Next Permutation: " +
                Arrays.toString(solution.nextPermutation(A2)));

        System.out.println("\nInput: " + Arrays.toString(A3));
        System.out.println("Next Permutation: " +
                Arrays.toString(solution.nextPermutation(A3)));

        System.out.println("\nInput: " + Arrays.toString(A4));
        System.out.println("Next Permutation: " +
                Arrays.toString(solution.nextPermutation(A4)));

        System.out.println("\nInput: " + Arrays.toString(A5));
        System.out.println("Next Permutation: " +
                Arrays.toString(solution.nextPermutation(A5)));
    }
}

