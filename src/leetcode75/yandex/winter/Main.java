package leetcode75.yandex.winter;

import java.io.*;

public class Main {

  /*
  Для чтения входных данных необходимо получить их
  из стандартного потока ввода (System.in).
  Данные во входном потоке соответствуют описанному
  в условии формату. Обычно входные данные состоят
  из нескольких строк. Можно использовать более производительные
  и удобные классы BufferedReader, BufferedWriter, Scanner, PrintWriter.

  С помощью BufferedReader можно прочитать из стандартного потока:
  * строку -- reader.readLine()
  * число -- int n = Integer.parseInt(reader.readLine());
  * массив чисел известной длины (во входном потоке каждое число на новой строке) --
  int[] nums = new int[len];
     for (int i = 0; i < len; i++) {
         nums[i] = Integer.parseInt(reader.readLine());
     }
  * последовательность слов в строке --
  String[] parts = reader.readLine().split(" ");

  Чтобы вывести результат в стандартный поток вывода (System.out),
  Через BufferedWriter можно использовать методы
  writer.write("Строка"), writer.write('A') и writer.newLine().

  Возможное решение задачи "Вычислите сумму чисел в строке":
  int sum = 0;
     String[] parts = reader.readLine().split(" ");
     for (int i = 0; i < parts.length; i++) {
         int num = Integer.parseInt(parts[i]);
         sum += num;
     }
     writer.write(String.valueOf(sum));
  */
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    String line;
    boolean[][] arr = new boolean[8][8];
    int index = 0;
    while ((line = reader.readLine()) != null) {
      for (int i = 0; i < 8; i++) {
        arr[index][i] = line.charAt(i) == '.';
      }
      index++;
    }
    int count = 0;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        // check  - - -
        //          -
        if (i < 7 && j < 6) {
          if (arr[i][j] && arr[i][j + 1] && arr[i][j + 2] && arr[i + 1][j + 1]) {
            count++;
          }
        }
        //  =
        // ===
        //
        if (i >= 1 && j < 6) {
          if (arr[i][j] && arr[i][j + 1] && arr[i][j + 2] && arr[i - 1][j + 1]) {
            count++;
          }
        }
        //  =
        //  = =
        //  =
        if (i < 6 && j < 7) {
          if (arr[i][j] && arr[i + 1][j] && arr[i + 2][j] && arr[i + 1][j + 1]) {
            count++;
          }
        }
        //  =
        // ==
        //  =
        if (i < 6 && j > 0) {
          if (arr[i][j] && arr[i + 1][j] && arr[i + 2][j] && arr[i + 1][j - 1]) {
            count++;
          }
        }
      }
    }
    writer.write(String.valueOf(count));

    reader.close();
    writer.close();
  }
}
