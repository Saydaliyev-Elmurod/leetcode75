/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        return isValid(Long.MIN_VALUE, root.left, root.val) && isValid(root.val, root.right, Long.MAX_VALUE);

    }

    public boolean isValid(long min, TreeNode root, long max) {
        if (root == null)
            return true;
        if (min < root.val && root.val < max) {
            return isValid(root.val, root.right, max) && isValid(min, root.left, root.val);
        }
        return false;
    }
}