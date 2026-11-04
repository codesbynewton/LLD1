package dsa;

/*
Given a set of distinct integers A,
return all possible subsets that can be formed from the elements of array A.
 */



import java.util.ArrayList;

public class GenerateSubsets {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        recur(A, 0, new ArrayList<>(), res);

        return res;
    }

    private void recur(ArrayList<Integer> arr, int idx,
                       ArrayList<Integer> ans,
                       ArrayList<ArrayList<Integer>> res) {

        if (idx == arr.size()) {
            res.add(new ArrayList<>(ans));
            return;
        }

        // Include the current element
        ans.add(arr.get(idx));
        recur(arr, idx + 1, ans, res);

        // Backtrack
        ans.remove(ans.size() - 1);

        // Exclude the current element
        recur(arr, idx + 1, ans, res);
    }

    public static void main(String[] args) {

        GenerateSubsets solution = new GenerateSubsets();

        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);

        ArrayList<ArrayList<Integer>> result = solution.subsets(A);

        System.out.println("All subsets:");

        for (ArrayList<Integer> subset : result) {
            System.out.println(subset);
        }

        System.out.println("Total subsets: " + result.size());
    }
}

