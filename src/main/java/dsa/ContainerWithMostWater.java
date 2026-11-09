package dsa;

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
