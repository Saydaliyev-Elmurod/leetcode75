package leetcode75.tree.levelOrder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        solution(root, 0, list);
        return list;
//        int height = height(root);
//        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 0;i<height;i++){
//            list.addAll(Objects.requireNonNull(toList(root, i)));
//        }
//        return list;
    }

    private void solution(final TreeNode root, final int level, final List<List<Integer>> list) {
        if (root == null) return;
        if (list.size() == level) {
            List<Integer> a = new ArrayList<>();
            a.add(root.val);
            list.add(a);
        } else {
            list.get(level).add(root.val);
        }
        solution(root.left, level + 1, list);
        solution(root.right, level + 1, list);
    }

    private List<List<Integer>> toList(final TreeNode root, final int height) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        else if (height == 1) return new ArrayList<>(root.val);
        else if (height > 1) {
            List<List<Integer>> left = toList(root.left, height - 1);
            List<List<Integer>> right = toList(root.right, height - 1);
            left.addAll(right);
            return left;
        }
        return new ArrayList<>();
    }

    public int height(TreeNode node) {
        if (node == null) return 0;
        int leftH = height(node.left);
        int rightH = height(node.right);
        return Math.max(leftH, rightH) + 1;
    }


}