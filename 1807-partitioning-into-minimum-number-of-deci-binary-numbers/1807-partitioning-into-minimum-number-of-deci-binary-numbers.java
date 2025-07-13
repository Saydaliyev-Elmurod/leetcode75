class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(int i = 0;i<n.length();i++){
            char ch = n.charAt(i);
            if(ch=='9') return 9;
            max = Math.max(max,Integer.valueOf(ch+""));
        }
        return max;
    }
}