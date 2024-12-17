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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return null;
        int middle = (n - 1) / 2;
        return new TreeNode(nums[middle], sortedArrayToBST(Arrays.copyOfRange(nums, 0, middle)),
                sortedArrayToBST(Arrays.copyOfRange(nums, middle + 1, n)));

    }
}