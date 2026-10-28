package dsa.mergesortedoverlappingintervals;


import java.util.ArrayList;
import java.util.List;

public class MergeSortedOverlappingIntervals {
    public int[][] solve(int[][] A) {
        List<int[]> list = new ArrayList<>();

        int start = A[0][0];
        int end = A[0][1];

        for(int i = 1; i < A.length; i++){
            //overlap
            if(A[i][0] <= end){
                end = Math.max(end, A[i][1]);
            } else {
                list.add(new int[]{start, end});
                start = A[i][0];
                end = A[i][1];
            }
        }

        list.add(new int[]{start, end});

        int[][] res = new int[list.size()][2];
        int idx = 0;

        for(int[] i : list){
            res[idx][0] = i[0];
            res[idx][1] = i[1];
            idx++;
        }

        return res;
    }

    public static void main(String[] args) {
        MergeSortedOverlappingIntervals solution = new MergeSortedOverlappingIntervals();

        int[][] A = {
                {1, 3},
                {2, 6},
                {8, 10},
                {9, 12},
                {15, 18}
        };

        int[][] result = solution.solve(A);

        for (int[] interval : result) {
            System.out.println(
                    "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }
}
