package part02;

import suportclasses.ListNode;

class MyLinkedList {
    ListNode head;
    ListNode tail;
    public MyLinkedList() {
    }

    public int get(int index) {
        return  0;
    }

    public void addAtHead(int val) {
        head = new ListNode(val);
        tail = head;
    }

    public void addAtTail(int val) {
        tail.next = new ListNode(val);
        tail.prev = tail;
        tail = tail.next;
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
        obj.addAtTail(4);
        printLinkedList(obj.head);

        obj.addAtIndex(1, 36);
        printLinkedList(obj.head);
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
