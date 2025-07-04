class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int n : nums) {
            int temp = k - n;
            Integer exist = map.get(temp);
            if (exist != null) {
                count++;
                if (exist == 1) {
                    map.remove(temp);
                } else {
                    map.put(temp, exist - 1);
                }
            } else {
                map.put(n,map.getOrDefault(n, 0)+1);
            }
        }
        return count;

    }
}