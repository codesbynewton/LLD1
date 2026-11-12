package dsa;

/*
Problem Description

Given a binary tree of integers denoted by root A.
Return an array of integers representing the top view of the Binary tree.
The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
Return the nodes in any order.
 */

import java.util.*;

public class TopViewBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    private class Pair {
        public int vNo;
        public TreeNode node;

        Pair(int vNo, TreeNode node) {
            this.vNo = vNo;
            this.node = node;
        }
    }

    public ArrayList<Integer> solve(TreeNode A) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, ArrayList<TreeNode>> hm = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        if (A == null) return ans;

        Pair pair = new Pair(0, A);
        queue.add(pair);

        while (!queue.isEmpty()) {
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                Pair rem = queue.remove();

                if (hm.containsKey(rem.vNo)) {
                    hm.get(rem.vNo).add(rem.node);
                } else {
                    ans.add(rem.node.val);
                    ArrayList<TreeNode> arr = new ArrayList<>();
                    arr.add(rem.node);
                    hm.put(rem.vNo, arr);
                }

                if (rem.node.left != null) {
                    queue.add(new Pair(rem.vNo - 1, rem.node.left));
                }

                if (rem.node.right != null) {
                    queue.add(new Pair(rem.vNo + 1, rem.node.right));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TopViewBinaryTree solution = new TopViewBinaryTree();

        /*
                  1
                /   \
               2     3
              / \     \
             4   5     6
                    \
                     7
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        ArrayList<Integer> result = solution.solve(root);

        System.out.println("Top View: " + result);
    }
}