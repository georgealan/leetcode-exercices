package suportclasses;

public class SinglyLinkedList {
    private ListNode head;
    private ListNode tail;

    public SinglyLinkedList() {
        this.head = new ListNode(-1);
        this.tail = head;
    }

    public SinglyLinkedList(int value) {
        head = new ListNode(value);
        tail = head;
    }

    public void insertAtEnd(int value) {
        tail.next = new ListNode(value);
        tail = tail.next;
    }

    public void remove(int index) {
        int i = 0;
        ListNode curr = head;
        while (i < index && curr != null) {
            i++;
            curr = curr.next;
        }
        if (curr != null) {
            curr.next = curr.next.next;
        }
    }

    public void print() {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public ListNode getHead() {
        return head;
    }

    public ListNode getTail() {
        return tail;
    }
}
