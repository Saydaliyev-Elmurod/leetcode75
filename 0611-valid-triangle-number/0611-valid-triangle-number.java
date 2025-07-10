class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        // a1 a2 a3 a4 a5 a6
        // 1 2 3 6 7 8
        int left = 0;
        int right = 1;
        int count = 0;
        for (int i = nums.length-1; i >=0; i--) {
            int curr= nums[i];
            left = 0;
            right = i-1;
            count+=search(left,right,i,nums);
        }
        return count;
    }
    //  2 3 4 4
    public int search(int left,int right,int curr,int [] nums){
        int count = 0;
        while (left < right) {
            if (nums[left] + nums[right] > nums[curr]) {
                count += right - left;
                right--;
            } else {
                left++;
            }
        }
        return count;
    }
}