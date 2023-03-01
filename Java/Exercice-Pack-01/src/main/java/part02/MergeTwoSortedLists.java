package part02;

import suportclasses.ListNode;

/*
 TODO Leetcode exercise: 21. Merge Two Sorted Lists
  Link: https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        int[] n1 = {-9, 3};
        int[] n2 = {5, 7};

        ListNode nodeOne = makeListNode(n1);
        ListNode nodeTwo = makeListNode(n2);
        ListNode nodeThree = new ListNode(2);
        ListNode nodeFour = new ListNode(1);

        ListNode result = mergeTwoLists(nodeOne, nodeTwo);

        System.out.println("Result of merge two node lists");
        print(result);
    }

    static public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while (list1 != null && list2 != null) {
            if (list1.val == list2.val) {
                tail.next = new ListNode(list1.val);
                tail = tail.next;
                tail.next = new ListNode(list2.val);
                tail = tail.next;
                list1 = list1.next;
                list2 = list2.next;
            } else if (list1.val < list2.val){
                tail.next = new ListNode(list1.val);
                tail = tail.next;
                list1 = list1.next;
            } else {
                tail.next = new ListNode(list2.val);
                tail = tail.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            tail.next = list1; // merge all nodes that left in list1 into tail of head node
        } else {
            tail.next = list2;
        }

        return head.next; // hack to remove first node that is equal to 0.
    }

    public static ListNode makeListNode(int[] values) {
        ListNode nodeHead = new ListNode(values[0]);
        ListNode nodeTail = nodeHead;

        for (int i = 1; i < values.length; i++) {
            nodeTail.next = new ListNode(values[i]);
            nodeTail = nodeTail.next;
        }

        return nodeHead;
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
