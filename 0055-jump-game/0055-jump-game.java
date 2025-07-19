class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int [] arr = new int [n];
        arr[0]=1;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<Math.min(n,i+1+nums[i]);j++){
                arr[j]++;
            }
        }
        for(int i = 0;i<n;i++){
            if(arr[i]==0) return false;
        }
        return true;
    }
}