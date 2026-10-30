package dsa;

import java.util.Arrays;

public class RainWaterTrapped {

    public int trap(final int[] A) {

        int n = A.length;

        if (n < 3) {
            return 0;
        }

        int[] lMax = new int[n];
        int[] rMax = new int[n];

        lMax[0] = A[0];
        rMax[n - 1] = A[n - 1];

        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i - 1], A[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], A[i]);
        }

        int max = 0;

        for (int i = 1; i < n - 1; i++) {
            max += Math.min(lMax[i], rMax[i]) - A[i];
        }

        return max;
    }

    public static void main(String[] args) {

        RainWaterTrapped solution = new RainWaterTrapped();

        int[] A1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] A2 = {4, 2, 0, 3, 2, 5};
        int[] A3 = {3, 0, 2, 0, 4};
        int[] A4 = {1, 2};
        int[] A5 = {3, 3, 3, 3};

        System.out.println("Input: " + Arrays.toString(A1));
        System.out.println("Trapped Water: " + solution.trap(A1));

        System.out.println("\nInput: " + Arrays.toString(A2));
        System.out.println("Trapped Water: " + solution.trap(A2));

        System.out.println("\nInput: " + Arrays.toString(A3));
        System.out.println("Trapped Water: " + solution.trap(A3));

        System.out.println("\nInput: " + Arrays.toString(A4));
        System.out.println("Trapped Water: " + solution.trap(A4));

        System.out.println("\nInput: " + Arrays.toString(A5));
        System.out.println("Trapped Water: " + solution.trap(A5));
    }
}
