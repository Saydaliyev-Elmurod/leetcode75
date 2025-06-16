
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        generate(candidates, target, 0, 0, list);
        return result;
    }

    public void generate(int[] candidates, int target, int index, int sum, List<Integer> visited) {
        if (sum == target) {
            result.add(new ArrayList<>(visited));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            visited.add(candidates[i]);
            generate(candidates, target, i, sum + candidates[i], visited);
            visited.removeLast();
        }
    }

}

   