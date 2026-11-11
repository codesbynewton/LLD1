package dsa;

/*
Problem Description

You are given a linked list A
Each node in the linked list contains two pointers: a next pointer and a random pointer
The next pointer points to the next node in the list
The random pointer can point to any node in the list, or it can be NULL
Your task is to create a deep copy of the linked list A
The copied list should be a completely separate linked list from the original list,
but with the same node values and random pointer connections as the original list
You should create a new linked list B, where each node in B
has the same value as the corresponding node in A
The next and random pointers of each node in B should point to the
corresponding nodes in B (rather than A)
 */


public class CopyList {

    static class RandomListNode {
        int label;
        RandomListNode next;
        RandomListNode random;

        RandomListNode(int x) {
            label = x;
            next = null;
            random = null;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode current = head;
        while (current != null) {
            RandomListNode copyNode = new RandomListNode(current.label);
            copyNode.next = current.next;
            current.next = copyNode;
            current = copyNode.next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        RandomListNode originalHead = head;
        RandomListNode copyHead = head.next;
        RandomListNode currentCopy = copyHead;

        current = originalHead;
        while (current != null) {
            current.next = currentCopy.next;
            if (current.next != null) {
                currentCopy.next = current.next.next;
            } else {
                currentCopy.next = null;
            }
            current = current.next;
            currentCopy = currentCopy.next;
        }

        return copyHead;
    }

    public static void main(String[] args) {
        CopyList solution = new CopyList();

        // Create original linked list: 1 -> 2 -> 3
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);

        node1.next = node2;
        node2.next = node3;

        // Assign random pointers
        node1.random = node3;
        node2.random = node1;
        node3.random = node2;

        // Clone the linked list
        RandomListNode copiedHead = solution.copyRandomList(node1);

        // Print copied linked list
        RandomListNode temp = copiedHead;

        while (temp != null) {
            System.out.println(
                    "Label: " + temp.label +
                            ", Random: " + (temp.random != null ? temp.random.label : "null")
            );
            temp = temp.next;
        }
    }
}
