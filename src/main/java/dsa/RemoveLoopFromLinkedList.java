package dsa;



public class RemoveLoopFromLinkedList {

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode solve(ListNode A) {
        if (A == null || A.next == null) return A;

        ListNode slow = A;
        ListNode fast = A;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) return A;

        slow = A;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode cycleStart = slow;

        ListNode ptr = cycleStart;

        while (ptr.next != cycleStart) {
            ptr = ptr.next;
        }

        ptr.next = null;

        return A;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        RemoveLoopFromLinkedList solution = new RemoveLoopFromLinkedList();

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Create cycle: 5 -> 3
        node5.next = node3;

        System.out.println("Cycle created: 5 -> 3");

        // Remove cycle
        ListNode result = solution.solve(head);

        System.out.println("After removing cycle:");
        printList(result);
    }
}