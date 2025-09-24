class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            int index = ch - 'a';
            map.put(ch, map.get(ch) - 1);

            if (used[index]) {
                continue;
            }

            while (!stack.isEmpty() && ch < stack.peek() && map.get(stack.peek()) > 0) {
                char pop = stack.pop();
                used[pop - 'a'] = false;
            }

            stack.add(ch);
            used[index] = true;

        }

        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}