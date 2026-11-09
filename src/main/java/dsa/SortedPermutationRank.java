package dsa;

/*
Problem Description

Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.
 */

public class SortedPermutationRank {

        public int findRank(String A) {
            long rank = 1;
            long MOD = 1000003;
            int n = A.length();

            long[] fact = new long[n + 1];
            fact[0] = 1;
            for (int i = 1; i <= n; i++) {
                fact[i] = (fact[i - 1] * i) % MOD;
            }

            for (int i = 0; i < n; i++) {
                char currentChar = A.charAt(i);
                int smallerCount = 0;
                for (int j = i + 1; j < n; j++) {
                    if (A.charAt(j) < currentChar) {
                        smallerCount++;
                    }
                }
                rank = (rank + (smallerCount * fact[n - 1 - i]) % MOD) % MOD;
            }

            return (int) rank;
        }

    public static void main(String[] args) {
        SortedPermutationRank solution = new SortedPermutationRank();

        String A = "acb";

        int result = solution.findRank(A);

        System.out.println("Lexicographic Rank: " + result);
    }

}
