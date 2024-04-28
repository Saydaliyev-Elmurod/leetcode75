package leetcode75.tree.maxDepth;


import leetcode75.tree.levelOrder.TreeNode;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int rightMax = maxDepth(root.right);
        int leftMax = maxDepth(root.left);
        return Math.max(rightMax, leftMax) + 1;
    }
}