package leetcode75.trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apple");
        trie.search("apple");
    }
}
