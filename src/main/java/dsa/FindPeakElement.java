package dsa;
/*
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors.
For corner elements, we need to consider only one neighbor.
 */

public class FindPeakElement {
    public int solve(int[] A) {
        int n = A.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is a peak
            boolean leftOk = (mid == 0 || A[mid] >= A[mid - 1]);
            boolean rightOk = (mid == n - 1 || A[mid] >= A[mid + 1]);

            if (leftOk && rightOk) {
                return A[mid];
            }

            // Move left if left neighbor is greater
            if (mid > 0 && A[mid - 1] > A[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindPeakElement solution = new FindPeakElement();

        int[] A = {1, 3, 5, 7, 6, 4, 2};

        int result = solution.solve(A);

        System.out.println("Peak Element: " + result);
    }
}
