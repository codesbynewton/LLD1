package dsa;

/*
Problem Description

Given a singly linked list A, determine if it's a palindrome.
Return 1 or 0, denoting if it's a palindrome or not, respectively.
 */
public class PalindromeList {

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public int lPalin(ListNode A) {
        if (A == null || A.next == null) return 1;

        ListNode mid = findMid(A);
        ListNode head1 = A;
        ListNode head2 = reverseList(mid.next);
        mid.next = null;

        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) return 0;
            head1 = head1.next;
            head2 = head2.next;
        }

        return 1;
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PalindromeList solution = new PalindromeList();

        // Test Case 1: 1 -> 2 -> 3 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.print("Linked List: ");
        printList(head);

        int result = solution.lPalin(head);

        System.out.println("Is Palindrome? " + (result == 1 ? "Yes" : "No"));
        System.out.println("Result: " + result);
    }
}
