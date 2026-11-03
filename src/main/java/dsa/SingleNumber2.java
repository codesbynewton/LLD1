package dsa;

/*
Problem Description

Given an array of integers, every element appears thrice except for one, which occurs once.

Find that element that does not appear thrice.

NOTE: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

 */

public class SingleNumber2 {

    public int singleNumber(final int[] A) {

        int ans = 0;
        int n = A.length;

        for (int i = 0; i < 32; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                count += (A[j] & (1 << i)) != 0 ? 1 : 0;
            }

            if (count % 3 != 0) {
                ans += 1 << i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        SingleNumber2 solution = new SingleNumber2();

        int[] A = {2, 2, 2, 5, 5, 5, 7};

        int result = solution.singleNumber(A);

        System.out.println("Single number: " + result);
    }
}