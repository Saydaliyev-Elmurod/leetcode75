package leetcode75.tree.preOrder;

import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // preorder traversal root ->left ->rigth
        List<Integer> result = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        result.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        if (left!=null) result.addAll(left);
        List<Integer> right = preorderTraversal(root.right);
        if (right!=null) result.addAll(right);
        return result;
    }

//    private List<Integer> traverse(TreeNode left) {
//        if (left==null) return null;
//
//    }
}