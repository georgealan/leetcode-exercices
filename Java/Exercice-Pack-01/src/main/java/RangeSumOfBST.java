import suportclasses.Node;
import suportclasses.Tree;
import suportclasses.Tree.*;
public class RangeSumOfBST {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = new Node(10);
        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root value " + root.left);
        tree.insert(root, 2);
        tree.insert(root, 4);
        tree.insert(root, 8);
        tree.insert(root, 6);
        tree.insert(root, 7);
        tree.insert(root, 3);
        tree.insert(root, 9);
        System.out.println("Traversing tree in order");
        tree.traverseInOrder(root);
    }
    /*public static int rangeSumBST(Tree root, int low, int high) {
        if(root == null)
            return 0;
        if(root.value < low)
            return rangeSumBST(root.right, low, high);
        if(root.value > high)
            return rangeSumBST(root.left, low, high);
        return root.value + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }*/
}
