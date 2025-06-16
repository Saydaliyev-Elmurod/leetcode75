package leetcode75.tree.search.iterator;

import leetcode75.tree.levelOrder.TreeNode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

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
class BSTIterator {
    Queue<Integer> stack;

    public BSTIterator(TreeNode root) {
        stack = new PriorityQueue<>() {
        };
        inOrder(root);
    }

    private void inOrder(final TreeNode root) {
        if (root==null) return;
        inOrder(root.left);
        stack.add(root.val);
        inOrder(root.right);
    }

    public int next() {
      return   stack.poll();
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */