class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        generate(0, n, k, new ArrayList());
        return result;
    }

    public void generate(int start, int end, int k, List<Integer> nums) {
        if (nums.size() == k) {
            result.add(new ArrayList(nums));
        }

        for (int n = start + 1; n <= end; n++) {
            nums.add(n);
            generate(n, end, k, nums);
            nums.remove(nums.size() - 1);
        }

    }
}