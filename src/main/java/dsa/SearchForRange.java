package dsa;

/*

Given a sorted array of integers A (0-indexed) of size N,
find the left most and the right most index of a given integer B in the array A.

Return an array of size 2, such that
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].

Note : Note: The time complexity of your algorithm must be O(log n)..
 */
public class SearchForRange {
    public int[] searchRange(final int[] A, int B) {
        int[] result = new int[2];
        result[0] = findLeftMost(A, B);
        result[1] = findRightMost(A, B);
        return result;
    }

    private int findLeftMost(int[] A, int B) {
        int low = 0, high = A.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A[mid] == B) {
                index = mid;
                high = mid - 1;
            } else if (A[mid] < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return index;
    }

    private int findRightMost(int[] A, int B) {
        int low = 0, high = A.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A[mid] == B) {
                index = mid;
                low = mid + 1; // keep looking on the right side
            } else if (A[mid] < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        SearchForRange solution = new SearchForRange();

        int[] A = {5, 7, 7, 8, 8, 10};
        int B = 8;

        int[] result = solution.searchRange(A, B);

        System.out.println("Leftmost Index: " + result[0]);
        System.out.println("Rightmost Index: " + result[1]);

        System.out.println("Result: [" + result[0] + ", " + result[1] + "]");
    }
}
