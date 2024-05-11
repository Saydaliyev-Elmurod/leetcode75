package leetcode75.tree.search.validate;

import leetcode75.tree.levelOrder.TreeNode;

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
        if (root != null) {
            boolean validBSTLeft = true;
            boolean validBSTRight = true;
            if (root.left != null) {
                if (root.val >= root.left.val) {
                    validBSTLeft = isValidBST(root.left);
                    validBSTRight = isValidBST(root.right);
                } else {
                    return false;
                }
            }
            if (!(validBSTRight&&validBSTLeft)) return false;
            if (root.right != null) {
                if (root.val <= root.right.val) {
                    validBSTRight = isValidBST(root.right);
                    validBSTLeft = isValidBST(root.left);
                } else {
                    return false;
                }
            }
            return validBSTRight && validBSTLeft;
        }
        return true;
    }
}