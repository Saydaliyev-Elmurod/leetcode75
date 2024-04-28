package leetcode75.tree.levelOrder;

public class Main {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node.right.right = node4;
        node.right.left = node3;
        Solution solution = new Solution();
        System.out.println(solution.levelOrder(node));
    }


}
