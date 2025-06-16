package leetcode75.leetcode150.sameTree;

import leetcode75.tree.preOrder.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val) return false;
            boolean sameTree = isSameTree(p.left, q.left);
            if (sameTree) {
                return isSameTree(p.right, q.right);
            }
            return false;
        } else return p == null && q == null;
    }
}