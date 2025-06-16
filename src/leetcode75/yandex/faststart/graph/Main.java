package leetcode75.yandex.faststart.graph;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
//        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = reader.readLine().split(" ");
        int n = arr.length;
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(numbers);
        // + + +
        // - + +
        // - - +
        // - - -
        int product1 = numbers[n - 1] * numbers[n - 2] * numbers[n - 3];  // - - +
        int product2 = numbers[0] * numbers[1] * numbers[n - 1]; // - - +
        int product3 = Integer.MIN_VALUE;
        if (n > 3) {
            product3 = numbers[n - 4] * numbers[n - 2] * numbers[n - 3]; // - - +
        }
Set<Integer> set = new HashSet<>();
        // Выводим три числа, дающие максимальное произведение
        if (product1 >= product2 && product1 >=product3) {
            writer.write(numbers[n - 1] + " " + numbers[n - 2] + " " + numbers[n - 3]);
        } else if (product3 > product1 && product3 > product2) {
            writer.write(numbers[n - 4] + " " + numbers[n - 3] + " " + numbers[n - 2]);
        } else {
            writer.write(numbers[0] + " " + numbers[1] + " " + numbers[n - 1]);
        }

        reader.close();
        writer.close();
    }

}
