package suportclasses;

public abstract class SinglyLinkedList {
    ListNode head;
    ListNode tail;

    public SinglyLinkedList() {
        head = new ListNode(-1);
        tail = head;
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
}
