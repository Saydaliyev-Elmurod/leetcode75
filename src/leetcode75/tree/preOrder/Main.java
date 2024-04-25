package leetcode75.tree.preOrder;


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tree = new TreeNode();
        tree.val = 1;
        tree.left = new TreeNode(12);
        tree.right = new TreeNode(9);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(6);
        solution.preorderTraversal(tree).forEach(System.out::println);
    }
}
