package leetcode75.sumquerires;

class NumArray {
  // ["NumArray","update","update","update","sumRange","update","sumRange","update","sumRange","sumRange","update"]
  // [[[7,2,7,2,0]],[4,6],[0,2],[0,9],[4,4],[3,8],[0,4],[4,1],[0,3],[0,4],[0,4]]
  // [null,null,null,null,6,null,32,null,26,27,null]
  public static void main(String[] args) {
    NumArray array = new NumArray(new int[] {1, 3, 5});
    array.sumRange(0, 2);
    array.update(1, 2);
    array.sumRange(0, 2);
  }

  int[] sum;
  int[] arr;

  public NumArray(int[] nums) {
    sum = new int[nums.length + 1];
    arr = nums;
    for (int i = 0; i < nums.length; i++) {
      sum[i + 1] = sum[i] + nums[i];
    }
  }

  public void update(int index, int val) {
    int old = arr[index];
    if (old != val) {
      int diff = val - old;
      for (int i = index + 1; i < sum.length; i++) {
        sum[i] += diff;
      }
    }
    arr[index] = val;
  }

  public int sumRange(int left, int right) {
    return sum[right + 1] - sum[left];
  }
}
