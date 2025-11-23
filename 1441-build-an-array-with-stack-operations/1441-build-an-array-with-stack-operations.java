class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int last = 1;
        for (int i : target) {
            for (int j = last; j < i; j++) {
                result.add("Push");
                result.add("Pop");
            }
            result.add("Push");
            last = i+1;
        }
        return result;
    }
}