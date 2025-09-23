class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < guess.length(); i++) {
            char curr = guess.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char curr = secret.charAt(i);
            if (curr == guess.charAt(i)) {
                bulls++;
                int count = map.get(curr);
                map.put(curr, count - 1);
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            char curr = secret.charAt(i);
            if (curr != guess.charAt(i)) {
                Integer count = map.get(curr);
                if (count != null && count > 0) {
                    map.put(curr, count - 1);
                    cows++;
                }
            }

        }
        return bulls + "A" + cows + "B";
    }
}