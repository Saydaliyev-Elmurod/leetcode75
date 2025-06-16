package leetcode75.trie;

import java.util.HashMap;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String str : wordDict) {
            trie.insert(str);
        }
        return trie.isContains(s, new HashMap<>());
    }

    public static class Trie {
        public Node root;

        public Trie() {
            root = new Node();
        }

        public static class Node {
            Node[] child;
            boolean isEnd;

            public Node() {
                child = new Node[26];
                isEnd = false;
            }
        }

        public void insert(String s) {
            Node curr = root;
            for (Character ch : s.toCharArray()) {
                int index = ch - 'a';
                if (curr.child[index] == null) {
                    curr.child[index] = new Node();
                }
                curr = curr.child[index];
            }
            curr.isEnd = true;
        }

        public boolean isContains(String str, HashMap<String, Boolean> memo) {
            Node curr = root;
            if (str.isEmpty())
                return true;
            if (memo.containsKey(str))
                return memo.get(str);
            for (int i = 0; i < str.length(); i++) {
                int index = str.charAt(i) - 'a';
                Node node = curr.child[index];

                if (node == null)
                    break;
                curr = node;
                if (node.isEnd) {
                    if (isContains(str.substring(i + 1), memo)) {
                        memo.put(str, true);
                        return true;
                    }
                }
            }
            memo.put(str, false);
            return false;
        }
    }
}