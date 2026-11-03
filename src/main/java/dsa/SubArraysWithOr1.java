package dsa;

/*
Problem Description

You are given a binary array A of length N where each element is either 0 or 1.

Your task is to count the number of subarrays where the bitwise
OR of all the elements in the subarray is 1.
 */


public class SubArraysWithOr1 {

    public int subarraysWithOR1(int[] A) {

        int n = A.length;
        int total = (n * (n + 1)) / 2;
        int zeroSub = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {

            if (A[i] == 0) {
                count++;
            } else {
                zeroSub += (count * (count + 1)) / 2;
                count = 0;
            }
        }

        zeroSub += (count * (count + 1)) / 2;

        return total - zeroSub;
    }

    public static void main(String[] args) {

        SubArraysWithOr1 solution = new SubArraysWithOr1();

        int[] A = {0, 1, 0, 0, 1};

        int result = solution.subarraysWithOR1(A);

        System.out.println("Subarrays with OR = 1: " + result);
    }
}