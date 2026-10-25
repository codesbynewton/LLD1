package dsa.damagedroads;

import java.util.Arrays;

public class Solution {
    static final long MOD = 1000000007;

    public int solve(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        Arrays.sort(A);
        Arrays.sort(B);

        int i = n - 1;
        int j = m - 1;

        long cost = 0;
        long verticalSegments = 1;
        long horizontalSegments = 1;

        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                cost = (cost + A[i] * horizontalSegments) % MOD;
                verticalSegments++;
                i--;
            } else {
                cost = (cost + B[j] * verticalSegments) % MOD;
                horizontalSegments++;
                j--;
            }
        }

        while (i >= 0) {
            cost = (cost + A[i] * horizontalSegments) % MOD;
            verticalSegments++;
            i--;
        }

        while (j >= 0) {
            cost = (cost + B[j] * verticalSegments) % MOD;
            horizontalSegments++;
            j--;
        }

        return (int)(cost % MOD);
    }
}
