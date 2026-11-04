package dsa;

/*
Given an integer A pairs of parentheses,
write a function to generate all combinations of well-formed parentheses of length 2*A.
 */



import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class GenerateParanthesis2 {

    public String[] generateParenthesis(int A) {
        List<String> recurRes = new ArrayList<>();

        solve("", A, recurRes, 0, 0);

        String[] res = new String[recurRes.size()];

        for (int i = 0; i < recurRes.size(); i++) {
            res[i] = recurRes.get(i);
        }

        return res;
    }

    private static void solve(String str, int n,
                              List<String> list,
                              int openCount, int closeCount) {

        if (openCount > n || closeCount > n || closeCount > openCount) {
            return;
        }

        if (str.length() == 2 * n) {
            list.add(str);
            return;
        }

        String open = str + '(';
        String close = str + ')';

        solve(open, n, list, openCount + 1, closeCount);
        solve(close, n, list, openCount, closeCount + 1);
    }

    public static void main(String[] args) {

        GenerateParanthesis2 solution = new GenerateParanthesis2();

        int A = 3;

        String[] result = solution.generateParenthesis(A);

        System.out.println("Valid Parentheses combinations:");

        for (String s : result) {
            System.out.println(s);
        }

        System.out.println("Total combinations: " + result.length);
    }
}
