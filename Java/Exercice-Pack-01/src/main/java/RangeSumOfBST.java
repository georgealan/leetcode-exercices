import suportclasses.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RangeSumOfBST {
    public static void main(String[] args) {
        // Create a TreeNode with the value 5
        TreeNode root = new TreeNode(5);

        // Create the left and right child nodes of the root node
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(7);

        // Set the left and right child nodes of the root node
        root.left = left;
        root.right = right;

        // Create the left and right child nodes of the left child node
        left.left = new TreeNode(2);
        left.right = new TreeNode(4);

        // Create the left and right child nodes of the right child node
        right.left = new TreeNode(6);
        right.right = new TreeNode(8);

        // Repeat the process for the next 8 layers
        left.left.left = new TreeNode(1);
        left.left.right = new TreeNode(2);
        left.right.left = new TreeNode(3);
        left.right.right = new TreeNode(4);
        right.left.left = new TreeNode(5);
        right.left.right = new TreeNode(6);
        right.right.left = new TreeNode(7);
        right.right.right = new TreeNode(8);


        printTreePyramid(root);

    }
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        if(root.val < low)
            return rangeSumBST(root.right, low, high);
        if(root.val > high)
            return rangeSumBST(root.left, low, high);
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public static void printTreePyramid(TreeNode root) {
        if (root == null) return;

        // Calculate the maximum depth of the tree
        int depth = maxDepth(root);

        // Create a list of lists to store the values at each level of the tree
        List<List<Integer>> pyramid = new ArrayList<>();

        // Add empty lists to the pyramid for each level of the tree
        for (int i = 0; i < depth; i++) {
            pyramid.add(new ArrayList<>());
        }

        // Add the root node to the first level of the pyramid
        pyramid.get(0).add(root.val);

        // Create a queue to store the nodes at each level of the tree
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Loop through the levels of the tree, starting at the second level
        for (int level = 1; level < depth; level++) {
            // Remove the first node from the queue
            TreeNode current = queue.remove();

            // Add the left and right child nodes of the current node to the queue
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);

            // Add the values of the left and right child nodes to the pyramid
            if (current.left != null) pyramid.get(level).add(current.left.val);
            if (current.right != null) pyramid.get(level).add(current.right.val);
        }

        // Loop through the levels of the pyramid
        for (int i = 0; i < pyramid.size(); i++) {
            // Print the values at the current level, separated by spaces
            for (int val : pyramid.get(i)) {
                System.out.print(val + " ");
            }
            // Move to the next line after printing the values at the current level
            System.out.println();
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        // Calculate the maximum depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return the larger of the two depths, plus 1 for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
