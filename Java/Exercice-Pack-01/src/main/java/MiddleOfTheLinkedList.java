import suportclasses.ListNode;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        //printList(node1);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(4);
        node2.next.next.next.next = new ListNode(5);
        node2.next.next.next.next.next = new ListNode(6);
        //printList(node2);

        printList(node1);
        ListNode result = middleNode(node1);
        printList(result);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fistPointer = head;
        ListNode secondPointer = head;

        while (secondPointer != null && secondPointer.next != null) {
            fistPointer = fistPointer.next;
            secondPointer = secondPointer.next.next;
        }
        return fistPointer;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
