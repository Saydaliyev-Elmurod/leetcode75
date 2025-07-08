class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map = new HashMap<>();
        for (int n : nums2) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
    }

    public void add(int index, int val) {
        int old = nums2[index];
        int count = map.get(old);
        if (count == 1) {
            map.remove(old);
        } else {
            map.put(old, count - 1);
        }
        nums2[index] += val;
        map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int n : nums1) {
            Integer temp = map.getOrDefault(tot - n, 0);
            count+=temp;
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */