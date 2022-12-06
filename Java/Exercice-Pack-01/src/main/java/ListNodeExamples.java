import suportclasses.ListNode;

public class ListNodeExamples {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        printList(head1);
        System.out.println();

        ListNode head2 = new ListNode(8);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(10);
        head2.next.next.next = new ListNode(11);
        head2.next.next.next.next = new ListNode(12);
        head2.next.next.next.next.next = new ListNode(13);
        printList(head2);
        System.out.println();

        ListNode mergeHead = mergeTwoLists(head1, head2);
        printList(mergeHead);
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // New List
        ListNode result = new ListNode(-1);
        // variable to point the last node of the list.
        ListNode p = result;

        // Iterate the loop
        while (l1 != null && l2 != null) {
            // Find the smaller element and append it to the list.
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            }

            else {
                p.next = l2;
                l2 = l2.next;
            }
            // Update the variable
            p = p.next;
        }

        // If anyone list become empty append the remaining list element of othe list.
        if (l1 == null) {
            p.next = l2;
        }

        else if (l2 == null) {
            p.next = l1;
        }

        // Return the resultant list without first extra node
        return result.next;
    }

    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val){
            head = head.next;
        }
        ListNode tmp = head;

        while (tmp!=null) {
            if (tmp.next!=null && tmp.next.val == val) {
                tmp.next=tmp.next.next;
            }
            else tmp=tmp.next;
        }
        if (tmp != null) {
            if (tmp.val == val) {
                tmp = tmp.next;
            }
        }
        return head;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
