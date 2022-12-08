import suportclasses.ListNode;
import suportclasses.TreeNode;

public class RangeSumOfBST {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(10);
        tree1.left = new TreeNode(5);
        tree1.left.right = new TreeNode(15);
        tree1.left.right.left = new TreeNode(3);
        tree1.left.right.left.right = new TreeNode(7);
        tree1.left.right.left.right.right = new TreeNode();
        tree1.left.right.left.right.right.right = new TreeNode(18);
        //printList(tree1);

        TreeNode tree2 = new TreeNode(10);
        tree2.left = new TreeNode(5);
        tree2.left.right = new TreeNode(15);
        tree2.left.right.left = new TreeNode(3);
        tree2.left.right.left.right = new TreeNode(7);
        tree2.left.right.left.right.right = new TreeNode(13);
        tree2.left.right.left.right.right.right = new TreeNode(18);
        tree2.left.right.left.right.right.right.left = new TreeNode(1);
        tree2.left.right.left.right.right.right.left.right = new TreeNode();
        tree2.left.right.left.right.right.right.left.right.right = new TreeNode(6);

        int result = rangeSumBST(tree1, 7, 15);
        System.out.println(result);

        int result2 = rangeSumBST(tree2, 6, 10);
        System.out.println(result2);
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

    public static void printList(TreeNode treeNode) {
        while (treeNode != null) {
            System.out.print(treeNode.val + " ");
        }
        System.out.println();
    }
}
