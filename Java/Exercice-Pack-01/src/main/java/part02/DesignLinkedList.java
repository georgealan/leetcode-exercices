package part02;

import suportclasses.ListNode;

/*
 TODO Leetcode exercise: 707. Design Linked List
  Link: https://leetcode.com/problems/design-linked-list/description/
 */

class MyLinkedList {
    ListNode node = null;
    public MyLinkedList() {

    }
    public int get(int index) {
        ListNode temp = node;

        while (temp != null) {
            if (index == 0) {
                System.out.println(temp.val);
                return temp.val;
            }
            temp = temp.next;
            index--;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);

        if (node == null) {
            newNode.prev = null;
            newNode.next = null;
            node = newNode;
        } else {
            newNode.prev = null;
            newNode.next = node;
            node.prev = newNode;
            node = newNode;
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
        }
    }

    public void addAtIndex(int index, int val) {
        if (node == null) {
            addAtHead(val);
        }

        ListNode temp = node;
        ListNode newNode = new ListNode(val);

        while (temp != null) {
            if (index == 0) {
                temp.prev.next = newNode;
                newNode.prev = temp.prev;
                newNode.next = temp;
                temp.prev = newNode;
                break;
            }
            temp = temp.next;
            index--;
        }
    }

    public void deleteAtIndex(int index) {
        if (node == null) { return; }
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

        if (node.prev == null && node.next == null) {
            node.val = -1;
            return;
        }

        node = node.next;
        node.prev = null;
    }

    public void deleteAtMiddle(ListNode node) {
        if (node == null) { return; }

        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    public void deleteAtTail() {
        if (node == null) { return; }
        ListNode temp = node;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }
}
public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        /*myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);*/

        /*myLinkedList.addAtHead(1);
        myLinkedList.deleteAtIndex(0);*/

        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3,0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        myLinkedList.get(4);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5,0);
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
