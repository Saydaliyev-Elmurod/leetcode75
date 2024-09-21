package leetcode75.hashMapSet.groupanagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    //https://leetcode.com/problems/group-anagrams/description/
        public List<List<String>> groupAnagrams(String[] strs) {
            // sort all string
            // ate,eat,tae
            // aet
            HashMap<String, List<String>> map = new HashMap<>();
            int n = strs.length;
            for (String str : strs) {
                char[] ch = str.toCharArray();
                Arrays.sort(ch);
                String temp = Arrays.toString(ch);
                List<String> values = map.getOrDefault(temp, new ArrayList<>());
                values.add(str);
                map.put(temp, values);
            }

            return  map.values().stream().toList();
        }
    }