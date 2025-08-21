package leetcode75.stack.sa;

import java.util.Stack;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.simplifyPath("/.../a/../b/c/../d/./"));
  }

  public String simplifyPath(String path) {
    // .. remove parent directory
    // / ignore
    // if not start / add
    //
    String[] arr = path.split("/");
    Stack<String> stack = new Stack<>();
    for (String curr : arr) {
      if (curr.isEmpty() || curr.equals(".")) {
        continue;
      }
      if (curr.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
        continue;
      }
      stack.add(curr);
    }
    StringBuilder sb = new StringBuilder();
    if (stack.isEmpty()) {
      return "/";
    }
    for (String s : stack) {
      if (!s.isEmpty()) {
        sb.append("/").append(s);
      }
    }
    return sb.toString();
  }
}
