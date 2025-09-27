class Solution {
    public String majorityFrequencyGroup(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Map<Integer, LinkedList<Character>> freq = new HashMap<>();
        int res = 0;
        int size = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            LinkedList<Character> letters = freq.computeIfAbsent(entry.getValue(), a -> new LinkedList<>());
            letters.add(entry.getKey());
            if (letters.size() > size || (letters.size() == size && res < entry.getValue())) {
                size = letters.size();
                res = entry.getValue();
            }
        }
        LinkedList<Character> l = freq.getOrDefault(res, new LinkedList<>());
        StringBuilder d = new StringBuilder();
        for (Character ch : l) {
            d.append(ch);
        }
        return d.toString();
    }
}