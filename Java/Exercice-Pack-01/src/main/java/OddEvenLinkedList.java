import suportclasses.ListNode;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        printList(node1);

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(1);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(5);
        node2.next.next.next.next = new ListNode(6);
        node2.next.next.next.next.next = new ListNode(4);
        node2.next.next.next.next.next.next = new ListNode(7);
        printList(node2);

        ListNode result = oddEvenList(node2);
        printList(result);

    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) { return null; }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
