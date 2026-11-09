package dsa;

/*
Problem Description

Given N non-negative integers A[0], A[1], ..., A[N-1] ,
where each represents a point at coordinate (i, A[i]).

N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).

Find two lines, which together with x-axis forms a container,
such that the container contains the most water. You need to return this maximum area.
 */

public class ContainerWithMostWater {


        public int maxArea(int[] A) {

            int n = A.length;
            int l = 0;
            int r = n-1;
            int ans = Integer.MIN_VALUE;
            while(l<r){
                int water = (r-l) * Math.min(A[r], A[l]);
                ans = Math.max(water, ans);

                if(A[l] > A[r]) r--;
                else l++;
            }

            return ans == Integer.MIN_VALUE ? 0 : ans;
        }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        int[] A = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = solution.maxArea(A);

        System.out.println("Maximum Water Area: " + result);
    }


}
