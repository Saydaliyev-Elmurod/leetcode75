package leetcode75.stack.decodeString;

import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DecodeString {
    public String decodeString(String s) {
        // 3[a]2[bc]->aaabcbc
        // 3[a2[c]] -> accaccacc
        // 2[abc]3[cd]ef -> abcabccdcdcdef
        // 3[a4[e2[r2[t]]]]] -> aerttrtterttrtterttrtterttrttaerttrtterttrtterttrtterttrttaerttrtterttrtterttrtterttrtt
        Stack<Integer> numberStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder number = new StringBuilder();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (Character.isDigit(character)) {
                number.append(character);
            } else if (character == '[') {
                // raqam tugadi uni stackga joylaymiz
                numberStack.push(Integer.valueOf(number.toString()));
                number = new StringBuilder();
                stringStack.push(text);
                text = new StringBuilder();
            } else if (character == ']') {
                int k = numberStack.pop();
                StringBuilder temp;
                temp = stringStack.pop();
                while (k-- > 0) {
                    temp.append(text);
                }
                text = temp;
            } else {
                text.append(character);
            }
        }
        return text.toString();
    }


}
