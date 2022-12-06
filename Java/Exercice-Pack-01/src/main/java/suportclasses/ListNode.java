package suportclasses;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode() {
        this.val = 0;
        this.next = null;
    }
}
