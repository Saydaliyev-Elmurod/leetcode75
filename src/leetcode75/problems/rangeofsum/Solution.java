package leetcode75.problems.rangeofsum;

import leetcode75.tree.preOrder.TreeNode;

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
    //https://leetcode.com/problems/range-sum-of-bst/description/
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root != null && root.val >= low && root.val <= high) {
            System.out.println(root.val);
            return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) + root.val;
        } else if (root != null && root.val <= low) {
            return rangeSumBST(root.right, low, high) ;
        } else if (root != null) {
            return rangeSumBST(root.left, low, high) ;
        }
        return 0;
    }
}