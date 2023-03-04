package part02;

import suportclasses.ListNode;

/*
 TODO Leetcode exercise: 707. Design Linked List
  Link: https://leetcode.com/problems/design-linked-list/description/
 */

class MyLinkedList {
    ListNode node = null;
    int lenght;
    public MyLinkedList() {
        this.lenght = 0;
    }
    public int get(int index) {
        System.out.println("In get(), value of index before: " + index);
        System.out.println("At get() method, Lenght value: " + lenght);
        if (index < lenght && index >= 0) {
            ListNode temp = node;
            while (index > 0) {
                temp = temp.next;
                index--;
            }
            System.out.println("In get(), value of index: " +
                    index + " value of return: " + temp.val);
            return temp.val;
        } else {
            return -1;
        }
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);

        if (node == null) {
            newNode.prev = null;
            newNode.next = null;
            node = newNode;
            lenght++;
        } else {
            newNode.prev = null;
            newNode.next = node;
            node.prev = newNode;
            node = newNode;
            lenght++;
        }
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);

        if (node == null) {
            addAtHead(val);
        } else {
            ListNode last = node;

            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
            newNode.prev = last;
            newNode.next = null;
            lenght++;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index > lenght) { return; }

        if (node == null || index == 0) {
            addAtHead(val);
            return;
        }

        if (index == lenght) {
            addAtTail(val);
            return;
        }

        ListNode temp = node;
        ListNode newNode = new ListNode(val);

        while (temp != null) {
            if (index == 0) {
                temp.prev.next = newNode;
                newNode.prev = temp.prev;
                newNode.next = temp;
                temp.prev = newNode;
                lenght++;
                break;
            }
            temp = temp.next;
            index--;
        }
    }

    public void deleteAtIndex(int index) {
        if (node == null) { return; }
        if (index < lenght && index >= 0) {
            ListNode temp = node;

            while (temp != null) {
                if (index == 0) {
                    callDelete(temp);
                    break;
                }
                temp = temp.next;
                index--;
            }
        }
    }

    public void callDelete(ListNode node) {
        if (node.prev == null) {
            deleteAtHead();
        } else if (node.next != null) {
            deleteAtMiddle(node);
        } else {
            deleteAtTail();
        }
    }

    public void deleteAtHead() {
        if (node == null) { return; }

        if (node.next == null && node.prev == null) {
            node = null;
            lenght--;
        } else {
            node = node.next;
            node.prev = null;
            lenght--;
        }
        System.out.println("Value of lenght after delete at head: " + lenght);
    }

    public void deleteAtMiddle(ListNode node) {
        if (node == null) { return; }

        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        lenght--;
        System.out.println("Value of lenght after delete at middle: " + lenght);
    }

    public void deleteAtTail() {
        if (node == null) { return; }
        ListNode temp = node;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        lenght--;
        System.out.println("Value of lenght after delete at tail: " + lenght);
    }
}
public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);

        printLinkedList(myLinkedList.node);

        myLinkedList.addAtIndex(3, 0);
        printLinkedList(myLinkedList.node);

        myLinkedList.deleteAtIndex(2);
        printLinkedList(myLinkedList.node);

        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        printLinkedList(myLinkedList.node);

        myLinkedList.get(4);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5, 0);
        myLinkedList.addAtHead(6);

        printLinkedList(myLinkedList.node);

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
