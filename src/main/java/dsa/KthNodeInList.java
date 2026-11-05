package dsa;

/*
You are given a singly linked list and an integer k.
Your task is to access the node at the k-th index (0-based indexing) in the list and return its value.
If the index is out of bounds, return -1.
 */



public class KthNodeInList {

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public int solve(ListNode A, int B) {
        ListNode temp = A;

        for (int i = 0; i < B; i++) {
            if (temp == null) {
                return -1;
            }
            temp = temp.next;
        }

        if (temp == null) return -1;

        return temp.val;
    }

    public static void main(String[] args) {
        KthNodeInList solution = new KthNodeInList();

        // Creating linked list: 10 -> 20 -> 30 -> 40 -> 50
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

        int B = 2;

        int result = solution.solve(head, B);

        System.out.println("Result: " + result);
    }
}