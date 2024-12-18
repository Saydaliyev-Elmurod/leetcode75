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
    public List<String> binaryTreePaths(TreeNode root) {
        // 1->2->3
        Set<String> result = new HashSet<>();
        return new ArrayList<>(binaryTreePaths(result, root, ""));
    }

    public Set<String> binaryTreePaths(Set<String> result, TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            path = path + root.val;
            result.add(path);
            return result;
        }
        if (root.left != null && root.right != null) {
            path = path + root.val + "->";
            Set<String> left = binaryTreePaths(result, root.left, path);
            Set<String> right = binaryTreePaths(result, root.right, path);
            result.addAll(left);
            result.addAll(right);
            return result;
        }
        if (root.left != null) {
            path = path + root.val + "->";
            return binaryTreePaths(result, root.left, path);
        }
        if (root.right != null) {
            path = path + root.val + "->";
            return binaryTreePaths(result, root.right, path);
        }
        return result;
    }
}