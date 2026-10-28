package dsa.mergeksortedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> pq =
                new PriorityQueue<>((n1, n2) -> Integer.compare(n1.val, n2.val));

        for (ListNode node : a) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode res = new ListNode(-1);
        ListNode dummy = res;

        while (!pq.isEmpty()) {
            ListNode rem = pq.remove();
            dummy.next = rem;
            dummy = dummy.next;

            if (rem.next != null) {
                pq.add(rem.next);
            }
        }

        return res.next;
    }

    public static void main(String[] args) {
        MergeKSortedList solution = new MergeKSortedList();

        // First sorted linked list: 1 -> 4 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        // Second sorted linked list: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // Third sorted linked list: 2 -> 6
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ArrayList<ListNode> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        ListNode result = solution.mergeKLists(lists);

        // Print merged linked list
        while (result != null) {
            System.out.print(result.val);

            if (result.next != null) {
                System.out.print(" -> ");
            }

            result = result.next;
        }
    }
}