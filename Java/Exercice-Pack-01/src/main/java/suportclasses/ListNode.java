package suportclasses;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode prev;
    public ListNode() {
        this.val = 0;
        this.next = null;
        this.prev = null;
    }
    public ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
        this.prev = null;
    }
    public ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
