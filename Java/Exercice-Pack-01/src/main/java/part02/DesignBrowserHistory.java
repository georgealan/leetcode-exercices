package part02;

/*
 TODO Leetcode exercise: 1472. Design Browser History
  Link: https://leetcode.com/problems/design-browser-history/
*/



class BrowserHistory {
    class Node {
        String homepage;
        Node prev;
        Node next;
        Node(String homepage) {
            this.homepage = homepage;
            this.prev = null;
            this.next = null;
        }
    }
    int lenght;
    Node browser;
    public BrowserHistory(String homepage) {
        this.browser = new Node(homepage);
        this.lenght = 1;
    }

    public void visit(String url) {
        /*
        Here have to implement insert in the middle when visit back or forward in
        the middle of the node. It will be behave like insertion in the middle.
         */
        Node newVisit = new Node(url);
        Node lastVisit = browser;

        while (lastVisit.next != null) {
            lastVisit = lastVisit.next;
        }

        lastVisit.next = newVisit;
        newVisit.next = null;
        newVisit.prev = lastVisit;
        lenght++;
    }

    public String back(int steps) {
        /*
        The node move and still in the same position picked here.
         */
        Node browserHistory = browser;
        String url = "";

        System.out.println(browserHistory.next.next.prev.homepage);

        while (browserHistory.next != null) {
            browserHistory = browserHistory.next;
        }

        while (steps > 0) {
            browserHistory = browserHistory.prev;
            steps--;

            if (steps == 0) {
                url = browserHistory.homepage;
            }
        }
        System.out.println("Result of bck() method: " + url);
        return url;
    }

    public String forward(int steps) {

        return "";
    }
}
public class DesignBrowserHistory {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");

        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        browserHistory.visit("ardanlabs.com");
        printLinkedList(browserHistory.browser);

        browserHistory.back(2);
        browserHistory.back(1);
        printLinkedList(browserHistory.browser);

        /*browserHistory.forward(1);
        browserHistory.visit("linkedin.com");
        browserHistory.forward(2);
        browserHistory.back(2);
        browserHistory.back(7);*/

        System.out.println("\nValues:");
        System.out.println("Lenght value: " + browserHistory.lenght);


    }

    public static void printLinkedList(BrowserHistory.Node head) {
        BrowserHistory.Node curr = head;
        while (curr != null) {
            System.out.print(curr.homepage + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}
