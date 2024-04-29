package leetcode75.tree.pathSum;

import leetcode75.tree.levelOrder.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return sum(root, targetSum, 0);
    }

    private boolean sum(final TreeNode root, final int targetSum, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val + sum == targetSum;
        }
        boolean sum1 = sum(root.left, targetSum, sum + root.val);
        if (sum1) {
            return true;
        }
        return sum(root.right, targetSum, sum + root.val);
    }
    public static boolean hasPathSum2(TreeNode root, int k) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == k;
        return hasPathSum2(root.left, k - root.val) || hasPathSum2(root.right, k - root.val);
    }
}