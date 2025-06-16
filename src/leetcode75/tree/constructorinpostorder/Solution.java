package leetcode75.tree.constructorinpostorder;

import leetcode75.tree.levelOrder.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return null;
    }

    public List<Integer> inOrder(TreeNode node) {
        if (node == null) return new ArrayList<>();
        List<Integer> integers = inOrder(node.left);
        List<Integer> r = new ArrayList<>(integers);
        r.add(node.val);
        List<Integer> integers1 = postOrder(node.right);
        r.addAll(integers1);
        return r;
    }

    public List<Integer> postOrder(TreeNode node) {
        List<Integer> r = new ArrayList<>();
        if (node == null) return new ArrayList<>();
        List<Integer> integers = postOrder(node.left);
        List<Integer> integers1 = postOrder(node.right);
        r.addAll(integers);
        r.addAll(integers1);
        r.add(node.val);
        return r;
    }
}