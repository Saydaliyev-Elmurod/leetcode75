package leetcode75.daySolutions.june06;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> prefixSet = new HashSet<>(dictionary);
        return Arrays.stream(sentence.split(" ")).map(
                word -> isExist(prefixSet, word)
        ).collect(Collectors.joining(" "));
    }

    private String isExist(final Set<String> dictionary, final String existWord) {
        for (int i = 1; i < existWord.length(); i++) {
            String subWord = existWord.substring(0, i);
            if (dictionary.contains(subWord)) {
                return subWord;
            }
        }
        return existWord;
    }
}