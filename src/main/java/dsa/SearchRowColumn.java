package dsa;



public class SearchRowColumn {

    public int solve(int[][] A, int B) {
        int i = 0;
        int j = A[0].length - 1;

        while (i < A.length && j >= 0) {
            if (A[i][j] == B) {
                if (j > 0 && A[i][j - 1] == B) {
                    j--;
                    continue;
                }

                return (i + 1) * 1009 + (j + 1);
            }

            if (B < A[i][j]) {
                j--;
            } else {
                i++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchRowColumn solution = new SearchRowColumn();

        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int B = 5;

        int result = solution.solve(A, B);

        System.out.println("Result: " + result);
    }
}
