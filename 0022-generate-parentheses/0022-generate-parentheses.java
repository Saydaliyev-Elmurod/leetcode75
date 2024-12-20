class Solution {
    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList();
        print(n - 1, "(", n);
        return result;
    }

    public void print(int n, String str, int m) {
        if (n > 0 || m > 0) {
            if (m > 0)
                print(n, str + ")", m - 1);
            if (n > 0)
                print(n - 1, str + "(", m);
        } else {
            if (isValid(str)) {
                result.add(str);
            }
        }
    }

    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char item : str.toCharArray()) {
            if (!stack.isEmpty()&&item == ')') {
                char old = stack.pop();
                if (old != '(') {
                    return false;
                }
            } else {
                stack.push(item);
            }
        }
        return stack.isEmpty();
    }
}