package experiments;

import suportclasses.ListNode;

public class DoublyLinkedList {
    ListNode head = null;
//    ListNode tail = null;

    public void insertAtHead(int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) {
            newNode.prev = null;
            newNode.next = null;
            head = newNode;
        } else {
            newNode.prev = null;
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtTail(int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) {
            insertAtHead(val);
        } else {
            ListNode last = head;

            /*
             Next have to be null to find the tail of the node, because the last element of
             the node always have the next reference pointing to null, because aren't any
             other node forward to link.
             */
            while (last.next != null) {
                last = last.next; // Increment the position of the node, to the next node.
            }

            last.next = newNode; // Assign the next pointer to the new node created.
            newNode.prev = last;
            newNode.next = null;
        }
    }

    public void getNodeValueByKey(int key) {
        ListNode temp = head;

        while (temp != null) {
            if (temp.val == key) {
                String prev = "null";
                String next = "null";
                int val = temp.val;

                if (temp.prev != null) {
                    prev = String.valueOf(temp.prev.val);
                }

                if (temp.next != null) {
                    next = String.valueOf(temp.next.val);
                }

                System.out.println("The key value " + key + " was found in the node and are: " +
                        "prev[" + prev + "], " + "val[" + val + "], " + "next[" + next + "]");
                break;
            }
            temp = temp.next;
        }
    }

    public void changeValueAtIndex(int index, int val) {
        ListNode temp = head;

        while (temp != null) {
            if (index == 0) {
                temp.val = val;
                break;
            }
            temp = temp.next;
            index--;
        }
    }

    public void addNewNodeAtIndex(int index, int val) {
        if (head == null) {
            insertAtHead(val);
        }

        ListNode temp = head;
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

    public void deleteAtHead() {
        if (head == null) { return; }

        head = head.next;
        head.prev = null;
    }

    public void deleteAtMiddle(ListNode node) {
        if (node == null) { return; }

        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    public void deleteAtTail() {
        if (head == null) { return; }
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
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

    public void deleteByKey(int key) {
        if (head == null) { return; }
        ListNode temp = head;

        while (temp != null) {
            if (temp.val == key) {
                callDelete(temp);
                break;
            }
            temp = temp.next;
        }
    }

    public void deleteNodeAtIndex(int index) {
        if (head == null) { return; }
        ListNode temp = head;

        while (temp != null) {
            if (index == 0) {
                callDelete(temp);
                break;
            }
            temp = temp.next;
            index--;
        }
    }

    public void printNode() {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}
class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.insertAtHead(4);
        doublyLinkedList.insertAtHead(2);
        doublyLinkedList.insertAtTail(5);
        doublyLinkedList.insertAtTail(7);
        doublyLinkedList.insertAtTail(8);
        doublyLinkedList.insertAtTail(9);
        doublyLinkedList.insertAtTail(10);

        doublyLinkedList.printNode();
        doublyLinkedList.getNodeValueByKey(5);

        System.out.println("\nAdd value at index, before change value: ");
        doublyLinkedList.printNode();

        System.out.println("Add value at index, after change value: ");
        doublyLinkedList.changeValueAtIndex(2, 6);
        doublyLinkedList.printNode();

        System.out.println("\nAdd new node at determined index, before changes:");
        doublyLinkedList.printNode();
        System.out.println("Add new node at determined index, after changes:");
        doublyLinkedList.addNewNodeAtIndex(3, 28);
        doublyLinkedList.printNode();
        doublyLinkedList.getNodeValueByKey(6);
        doublyLinkedList.getNodeValueByKey(28);
        doublyLinkedList.getNodeValueByKey(7);

        System.out.println("\nBefore delete at head");
        doublyLinkedList.printNode();
        System.out.println("After delete at head");
        doublyLinkedList.deleteAtHead();
        doublyLinkedList.printNode();

        System.out.println("\nBefore delete at tail");
        doublyLinkedList.printNode();
        System.out.println("After delete at tail");
        doublyLinkedList.deleteAtTail();
        doublyLinkedList.printNode();

        doublyLinkedList.insertAtTail(31);
        doublyLinkedList.insertAtTail(32);
        doublyLinkedList.insertAtTail(33);
        doublyLinkedList.insertAtTail(34);
        doublyLinkedList.insertAtTail(35);

        System.out.println("\nBefore delete at tail by index");
        doublyLinkedList.printNode();
        System.out.println("After delete at tail by index");
        doublyLinkedList.deleteNodeAtIndex(8);
        doublyLinkedList.printNode();
        doublyLinkedList.getNodeValueByKey(32);
        doublyLinkedList.getNodeValueByKey(34);

        System.out.println("\nBefore delete by the key");
        doublyLinkedList.printNode();
        System.out.println("After delete by the key");
        doublyLinkedList.deleteByKey(8);
        doublyLinkedList.printNode();
        doublyLinkedList.getNodeValueByKey(9);
        doublyLinkedList.getNodeValueByKey(7);

    }
}
