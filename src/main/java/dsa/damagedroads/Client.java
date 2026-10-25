package dsa.damagedroads;

public class Client {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] A = {2, 1, 3, 1, 4};
        int[] B = {4, 1, 2};

        int result = solution.solve(A, B);

        System.out.println("Minimum Cost: " + result);
    }

}

// Problem statement

/*
You are the Prime Minister of a country and once you went for a world tour.
After 5 years, when you returned to your country,
you were shocked to see the condition of the roads between the cities.
So, you plan to repair them, but you cannot afford to spend a lot of money.
The country can be represented as a (N+1) x (M+1) grid, where Country(i, j) is a city.
The cost of repairing a road between (i, j) and (i + 1, j) is A[i].
The cost of repairing a road between (i, j) and (i, j + 1) is B[j].
Return the minimum cost of repairing the roads such that all cities can be visited
from city indexed (0, 0).
As the cost can be large, return the cost modulo 109+7.
 */
