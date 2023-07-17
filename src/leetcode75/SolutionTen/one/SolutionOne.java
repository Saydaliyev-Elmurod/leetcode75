package leetcode75.SolutionTen.one;

public class SolutionOne {
    public static void main(String[] args) {
        String s1 = "af";
        String s2 = "bvnbv";
        System.out.println(mergeAlternately(s1, s2));
    }

    public static String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Math.min(n1, n2); i++) {
            builder.append(word1.charAt(i));
            builder.append(word2.charAt(i));
        }
        if(n1>n2){
            builder.append(word1.substring(Math.min(n1,n2)));
        }else{
            builder.append(word2.substring(Math.min(n1,n2)));
        }
        return builder.toString();
    }
}
