package dsa.largestrectangle;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {

        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int height = A.get(i);
            int width = right[i] - left[i] + 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
