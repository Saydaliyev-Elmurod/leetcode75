package leetcode75.yandex;

import java.io.*;
import java.util.LinkedList;

public class Eight {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] str = reader.readLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int m = Integer.parseInt(str[1]);
    String line = reader.readLine();
    int index = 0;
    Trie trie = new Trie();
    while (m-- > 0) {
      String item = reader.readLine();
      ++index;
      trie.insert(item, index);
    }
    writer.write(trie.search(line));
    reader.close();
    writer.close();
  }

  public static class Trie {
    private static class TrieNode {
      TrieNode[] children;
      boolean isEndOfWord;
      LinkedList<Integer> indexes;

      public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
      }
    }

    private final TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    public void insert(String word, int indexWord) {
      TrieNode current = root;
      for (char ch : word.toCharArray()) {
        int index = ch - 'a';
        if (current.children[index] == null) {
          current.children[index] = new TrieNode();
        }
        current = current.children[index];
      }
      current.isEndOfWord = true;
      if (current.indexes == null) {
        current.indexes = new LinkedList<>();
      }
      current.indexes.add(indexWord);
    }

    public String search(String word) {
      TrieNode current = root;
      int len = word.length();
      int i = 0;
      StringBuilder result = new StringBuilder();
      while (i < len) {

        int index = word.charAt(i) - 'a';
        if (current.children[index] == null) {
          return "";
        }
        if (current.children[index].isEndOfWord) {
          LinkedList<Integer> indexes = current.children[index].indexes;
          if (indexes.isEmpty()) {
            current = current.children[index];
          } else {
            Integer deleted = indexes.removeFirst();
            result.append(deleted).append(" ");
            current = root;
          }
        } else {
          current = current.children[index];
        }
        i++;
      }
      return result.toString();
    }
  }
}
