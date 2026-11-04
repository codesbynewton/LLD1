package dsa;

/*
Given three integers A, B, and C, where A represents n,
B represents r, and C represents m,
find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

 */


import java.util.Arrays;

public class ComputeNcr {

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }

            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }

    public int solve(int A, int B, int C) {

        if (B > A || C == 0) {
            return 0;
        }

        if (C == 1) {
            return 0;
        }

        if (B == 0 || B == A) {
            return 1;
        }

        if (B > A - B) {
            B = A - B;
        }

        int[] dp = new int[B + 1];
        dp[0] = 1;

        for (int i = 1; i <= A; i++) {
            for (int j = Math.min(i, B); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % C;
            }
        }

        return dp[B];
    }

    public static void main(String[] args) {

        ComputeNcr solution = new ComputeNcr();

        int A = 5;
        int B = 2;
        int C = 13;

        int result = solution.solve(A, B, C);

        System.out.println("A = " + A);
        System.out.println("B = " + B);
        System.out.println("C = " + C);

        System.out.println("NCr % C = " + result);
    }
}
