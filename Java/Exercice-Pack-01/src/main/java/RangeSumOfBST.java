import suportclasses.ListNode;
import suportclasses.TreeNode;

public class RangeSumOfBST {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(10);

        TreeNode tree2 = new TreeNode(10);


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
