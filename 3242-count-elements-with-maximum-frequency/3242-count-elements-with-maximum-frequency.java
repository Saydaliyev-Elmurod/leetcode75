class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            int temp = freq.getOrDefault(n, 0) + 1;
            max = Math.max(max, temp);
            freq.put(n, temp);
        }
        int sum = 0;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == max) {
                sum += max;
            }
        }
        return sum;
    }
}