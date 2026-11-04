package dsa;

/*
Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
 */



import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Permutations {

    public int[][] permute(int[] A) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[A.length];

        recur(A, vis, new ArrayList<>(), res);

        int[][] result = new int[res.size()][];

        for (int i = 0; i < res.size(); i++) {
            List<Integer> innerList = res.get(i);
            result[i] = new int[innerList.size()];

            for (int j = 0; j < innerList.size(); j++) {
                result[i][j] = innerList.get(j);
            }
        }

        return result;
    }

    private void recur(int[] arr, boolean[] vis,
                       List<Integer> lsf,
                       List<List<Integer>> res) {

        if (lsf.size() == arr.length) {
            res.add(new ArrayList<>(lsf));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                lsf.add(arr[i]);

                recur(arr, vis, lsf, res);

                lsf.remove(lsf.size() - 1);
                vis[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        Permutations solution = new Permutations();

        int[] A = {1, 2, 3};

        int[][] result = solution.permute(A);

        System.out.println("All permutations:");

        for (int[] permutation : result) {
            System.out.println(Arrays.toString(permutation));
        }

        System.out.println("Total permutations: " + result.length);
    }
}
