class Solution {
    public int minOperations(String s) {
        Set<Character> set = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        int count = 0;
        for(int i = 1;i<26;i++){
            char curr= (char)('a'+i);
            if(set.contains(curr)){
                count++;
                set.add((char)(curr+1));
            }
        }
        return count;
    }
}