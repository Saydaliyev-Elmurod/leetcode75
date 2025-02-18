package leetcode75.trie;

class Trie {

    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            // Initialize the children array for 26 alphabets
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // Calculate the index for character
            if (current.children[index] == null) {
                current.children[index] = new TrieNode(); // Create child if not present
            }
            current = current.children[index];
        }
        current.isEndOfWord = true; // Mark the end of a word
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return false; // Character path doesn't exist, hence word not present
            }
            current = current.children[index];
        }
        return current.isEndOfWord; // Return true if it's the end of a word
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return false; // Prefix path doesn't exist
            }
            current = current.children[index];
        }
        return true; // Prefix exists
    }
}