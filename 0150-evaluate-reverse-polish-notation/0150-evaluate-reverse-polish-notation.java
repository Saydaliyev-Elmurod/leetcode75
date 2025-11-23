class Solution {
  public int evalRPN(String[] tokens) {
    Stack<String> stack = new Stack<>();
    for (String token : tokens) {
      if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
        int first = Integer.parseInt(stack.pop());
        int second = Integer.parseInt(stack.pop());
        if (token.equals("+")) {
          stack.push(String.valueOf(first + second));
        } else if (token.equals("-")) {
          stack.push(String.valueOf(second - first));
        } else if (token.equals("*")) {
          stack.push(String.valueOf(first * second));
        } else {
          stack.push(String.valueOf(second / first));
        }
      }else{
          stack.push(token);
      }
    }
    return Integer.parseInt(stack.pop());
  }
}
