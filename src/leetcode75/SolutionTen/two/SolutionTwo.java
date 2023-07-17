package leetcode75.SolutionTen.two;

public class SolutionTwo {
    public static void main(String[] args) {
        String sq = "AAAAAAAAA";
        String s2 = "AAACCC";
        System.out.println(gcdOfStrings(sq, s2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        String max = (n2 > n1) ? str2 : str1;
        String min = (n2 > n1) ? str1 : str2;
        return isDivide(max, min, 1);
    }

    private static String isDivide(String max, String min, int index) {
        int len = min.length();
        if (len / index == 0) {
            return "";
        } else if (len % index == 0) {
            String temp = min.substring(0, len / index);
            if(contain(min,temp)){
                if (contain(max, temp)) {
                    return temp;
                } else {
                    return isDivide(max, min, ++index);
                }
            }else{
                return isDivide(max, min, ++index);
            }

        } else {
            return isDivide(max, min, ++index);
        }
    }

    private static boolean contain(String max, String temp) {
        String s = temp;
        while (s.length() <= max.length()) {
            if (max.equals(s)) {
                return true;
            } else {
                s += temp;
            }
        }
        return false;

    }
}
