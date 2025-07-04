class Solution {
    public boolean closeStrings(String word1, String word2) {
        //aabbc  // aaabc

        if (word1.equals(word2))
            return true;
        if (word1.length() != word2.length()) {
            return false;
        }
        Set<Character> chars1 = word1.chars() // returns an IntStream
                .mapToObj(c -> (char) c) // convert int to char
                .collect(Collectors.toSet());
        ;
        Set<Character> chars2 = word2.chars() // returns an IntStream
                .mapToObj(c -> (char) c) // convert int to char
                .collect(Collectors.toSet());

        for (char ch : chars2) {
            if (!chars1.contains(ch)) {
                return false;
            }
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            char ch1 = word1.charAt(i);
            map1.put(ch1, map1.getOrDefault(ch1, 0) + 1);
            char ch2 = word2.charAt(i);
            map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);
        }
        List<Integer> val1 = new ArrayList<>(map1.values());
        List<Integer> val2 = new ArrayList<>(map2.values());
        Collections.sort(val1);
        Collections.sort(val2);
        for (int i = 0; i < val1.size(); i++) {
            if (!val1.get(i).equals(val2.get(i))) {
                return false;
            }
        }
        return true;
    }
}