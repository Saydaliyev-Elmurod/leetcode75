class Solution {
    public int[] sortArray(int[] nums) {
        int size = nums.length;
        if (size == 1)
            return nums;
        int[] first = Arrays.copyOfRange(nums,0, size / 2);
        int[] second = Arrays.copyOfRange(nums,size / 2, size);
        first = sortArray(first);
        second = sortArray(second);
        // 1 2
        int fI = 0;
        int sI = 0;
        while (fI < first.length && sI < second.length) {
            if (first[fI] < second[sI]) {
                nums[sI + fI] = first[fI];
                fI++;
            } else {
                nums[sI + fI] = second[sI];
                sI++;
            }
        }
        while (fI < first.length) {
            nums[sI + fI] = first[fI];
            fI++;
        }
        while (sI < second.length) {
            nums[sI + fI] = second[sI];
            sI++;
        }
        return nums;
    }
}