package leetcode75.yandex;

import java.io.*;

public class Three {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    String pass = reader.readLine();
    // abacaba 2+1+4+1+3+6+3+5+3
    // a4,b2 c1
    // abc acb cab cba
    int[] arr = new int[26];
    for (int i = 0; i < pass.length(); i++) {
      arr[pass.charAt(i) - 'a']++;
    }
    long sum = 0;
    for (int i = 0; i < pass.length(); i++) {
      int index = pass.charAt(i) - 'a';
      for (int j = 0; j < arr.length; j++) {
        if (arr[j] != 0 && j != index) {
          sum += arr[j];
        }
      }
    }
    writer.write(String.valueOf(sum / 2 + 1));
    reader.close();
    writer.close();
  }
}
