package part01;

import suportclasses.ListNode;

import java.util.LinkedList;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        /*ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);*/
        //printList(node1);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(7);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(5);
        node2.next.next.next.next = new ListNode(6);
        node2.next.next.next.next.next = new ListNode(4);
        node2.next.next.next.next.next.next = new ListNode(7);
        node2.next.next.next.next.next.next.next = new ListNode(4);
        node2.next.next.next.next.next.next.next.next = new ListNode(8);
        node2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        //printList(node2);

        /*ListNode result = oddEvenList(node2);
        printList(result);*/

        testLinkedListSolution(node2);
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

    public static void testLinkedListSolution(ListNode head) {
        LinkedList<Integer> oddNodes = new LinkedList<>();
        LinkedList<Integer> evenNodes = new LinkedList<>();

        System.out.print("Unmodified List: ");
        printList(head);

        while (head != null) {
            if (head.val % 2 == 0) {
                evenNodes.add(head.val);
            } else {
                oddNodes.add(head.val);
            }
            head = head.next;
        }

        System.out.print("Odd Numbers: ");
        oddNodes.forEach(n -> System.out.print(n + " "));

        System.out.print("\nEven Numbers: ");
        evenNodes.forEach(n -> System.out.printf(n + " "));
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
