package dsa;

/*
Problem Description

Given an array of positive integers A, two integers appear only once,
and all the other integers appear twice.
Find the two integers that appear only once.

Note: Return the two numbers in ascending order.
 */

import java.util.Arrays;

public class SingleNumber3 {

    public int[] solve(int[] A) {

        int ans = 0;
        int n = A.length;
        int[] nums = new int[2];

        for (int i = 0; i < n; i++) {
            ans ^= A[i];
        }

        int idx = -1;

        for (int i = 0; i < 32; i++) {
            if ((ans & 1) == 1) {
                idx = i;
                break;
            }

            ans = ans >> 1;
        }

        for (int i = 0; i < n; i++) {
            if ((A[i] & (1 << idx)) != 0) {
                nums[0] ^= A[i];
            } else {
                nums[1] ^= A[i];
            }
        }

        if (nums[0] > nums[1]) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
        }

        return nums;
    }

    public static void main(String[] args) {

        SingleNumber3 solution = new SingleNumber3();

        int[] A = {1, 2, 3, 1, 2, 4};

        int[] result = solution.solve(A);

        System.out.println("The two unique numbers are: "
                + Arrays.toString(result));
    }
}