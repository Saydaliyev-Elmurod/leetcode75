package leetcode75.tree.search.delete;


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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
inOrder(root.left);
            }
        } else if (root.val > key) {
            deleteNode(root.left, key);
        } else {
            deleteNode(root.right, key);
        }
        return root;
    }

    private void inOrder(final TreeNode left) {


    }
}