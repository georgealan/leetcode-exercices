package part02;

import suportclasses.ListNode;

/*
 TODO Leetcode exercise: 707. Design Linked List
  Link: https://leetcode.com/problems/design-linked-list/description/
 */

class MyLinkedList {
    ListNode head;
    ListNode tail;
    public MyLinkedList() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        return  0;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.prev = head;
        newNode.next = head.next;

        head.next.prev = newNode;
        head.next = newNode;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = tail;
        newNode.prev = tail.prev;

        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    public void addAtIndex(int index, int val) {
        int count = 0;

        while (head != null && count < index) {
            count++;
            head = head.next;
            if (count == index) {
                head.prev = new ListNode(val);
            }
        }
    }

    public void deleteAtIndex(int index) {

    }
}
public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();

        obj.addAtHead(1);
        obj.addAtTail(2);
        obj.addAtTail(3);

        printLinkedList(obj.head.next);

    }

    public static void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}
