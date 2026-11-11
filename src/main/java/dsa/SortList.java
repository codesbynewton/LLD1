package dsa;

/*
Problem Description

Sort a linked list, A in O(n log n) time.
 */

public class SortList {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null) return A;

        ListNode mid = findMid(A);
        ListNode l1 = A;
        ListNode l2 = mid.next;
        mid.next = null;

        ListNode left = sortList(l1);
        ListNode right = sortList(l2);

        return mergeSortedList(left, right);
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

    private ListNode mergeSortedList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        temp.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortList solution = new SortList();

        // Create linked list: 4 -> 2 -> 1 -> 3 -> 5
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        ListNode sortedHead = solution.sortList(head);

        System.out.print("Sorted List: ");
        printList(sortedHead);
    }
}
