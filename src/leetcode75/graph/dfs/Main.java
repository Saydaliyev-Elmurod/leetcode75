package leetcode75.graph.dfs;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPath(5, new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {0, 4}
        }, 4, 3));
    }
}
