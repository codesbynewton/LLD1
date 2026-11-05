package dsa;

/*
Given a sorted array of integers (not necessarily distinct) A and an integer B,
find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
 */


public class PairsWithGivenSum2 {

    public int solve(int[] A, int B) {
        int n = A.length;
        int i = 0;
        int j = n - 1;
        int ans = 0;
        int mod = 1_000_000_007;

        while (i < j) {
            int sum = A[i] + A[j];

            if (sum < B) {
                i++;
            } else if (sum > B) {
                j--;
            } else {
                if (A[i] == A[j]) {
                    int count = j - i + 1;
                    ans = (int) ((ans + ((long) count * (count - 1) / 2) % mod) % mod);
                    break;
                } else {
                    int a = 1;
                    int b = 1;

                    while (i + 1 < j && A[i] == A[i + 1]) {
                        i++;
                        a++;
                    }

                    while (j - 1 > i && A[j] == A[j - 1]) {
                        j--;
                        b++;
                    }

                    ans = (int) ((ans + ((long) a * b) % mod) % mod);

                    i++;
                    j--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        PairsWithGivenSum2 solution = new PairsWithGivenSum2();

        int[] A = {1, 1, 2, 2, 3, 3};
        int B = 4;

        int result = solution.solve(A, B);

        System.out.println("Number of pairs: " + result);
    }
}