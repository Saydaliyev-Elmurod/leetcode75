class Solution {

    Map<Character, String> phoneMap;
    List<String> result;

    public List<String> letterCombinations(String digits) {
        phoneMap = new HashMap<>();
        result = new ArrayList();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        if(digits.isEmpty()) return new ArrayList<>();
        print(digits, "");
        return result;
    }

    public void print(String digits, String res) {
        if (digits.isEmpty()) {
            result.add(res);
            return;
        }

        char ch = digits.charAt(0);
        String letter = phoneMap.get(ch);

        for (char i : letter.toCharArray()) {
            print(digits.substring(1), res + i);
        }
    }
}