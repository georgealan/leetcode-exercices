package part02;

/*
 TODO Leetcode exercise: 1472. Design Browser History
  Link: https://leetcode.com/problems/design-browser-history/
*/

import suportclasses.ListNode;

class BrowserHistory {
    String homepage;
    int lenght;
    ListNode node = null;
    public BrowserHistory(String homepage) {
        this.homepage = homepage;
        this.lenght = 0;
    }

    public void visit(String url) {

    }

    public String back(int steps) {

        return "";
    }

    public String forward(int steps) {

        return "";
    }
}
public class DesignBrowserHistory {
    public static void main(String[] args) {

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
