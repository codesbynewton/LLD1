package dsa;

/*
Problem Description

In the classic problem of the Towers of Hanoi,
you have 3 towers numbered from 1 to 3 (left to right)
and A disks numbered from 1 to A (top to bottom) of different sizes which can slide onto any tower.
The puzzle starts with disks sorted in ascending order of size from top to bottom
(i.e., each disk sits on top of an even larger one).
You have the following constraints:

Only one disk can be moved at a time.
A disk is slid off the top of one tower onto another tower.
A disk cannot be placed on top of a smaller disk.

You have to find the solution to the Tower of Hanoi problem.
You have to return a 2D array of dimensions M x 3,
where M is the minimum number of moves needed to solve the problem.
In each row, there should be 3 integers (disk, start, end), where:

disk - number of the disk being moved
start - number of the tower from which the disk is being moved
end - number of the tower to which the disk is being moved
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ToweOfHanoi {

    List<int[]> moves;

    public int[][] towerOfHanoi(int A) {

        moves = new ArrayList<>();

        solve(A, 1, 3, 2);

        int[][] result = new int[moves.size()][3];

        for (int i = 0; i < moves.size(); i++) {
            result[i] = moves.get(i);
        }

        return result;
    }

    private void solve(int n, int start, int end, int aux) {

        if (n == 0) return;

        solve(n - 1, start, aux, end);

        moves.add(new int[]{n, start, end});

        solve(n - 1, aux, end, start);
    }

    public static void main(String[] args) {

        ToweOfHanoi solution = new ToweOfHanoi();

        int A = 3;

        int[][] result = solution.towerOfHanoi(A);

        System.out.println("Tower of Hanoi moves:");

        for (int[] move : result) {
            System.out.println(Arrays.toString(move));
        }

        System.out.println("Total moves: " + result.length);
    }
}