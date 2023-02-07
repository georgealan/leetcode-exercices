package part02;

import suportclasses.ListNode;

/* TODO Leetcode exercise: 206. Reverse Linked List
    Link:  https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
    static ListNode head = new ListNode(1);
    static ListNode tail = head;

    public static void main(String[] args) {
        insertAtEnd(2);
        insertAtEnd(3);
        insertAtEnd(4);
        insertAtEnd(5);

        System.out.println("LinkedList before reverse:");
        print(head);

        System.out.println("LinkedList after be reversed:");
        ListNode reversed = reverseList(head);
        print(reversed);

    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    public static void insertAtEnd(int value) {
        tail.next = new ListNode(value);
        tail = tail.next;
    }

    public static void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}

/*
Explanation:

 */