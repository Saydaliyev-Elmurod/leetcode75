class Solution {
    public String makeFancyString(String s) {
        int count = 0;
        StringBuilder res = new StringBuilder("");
        char last = '1';
        for(int i = 0;i<s.length();i++){
             char curr = s.charAt(i);
             if(curr==last){
                if(count<2){
                    res.append(curr);
                }
                count++;
             }else{
                    res.append(curr);
                count = 1;
                last=curr;
             }
        }
        return res.toString();
    }
}