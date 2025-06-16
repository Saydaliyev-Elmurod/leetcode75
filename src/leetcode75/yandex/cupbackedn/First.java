package leetcode75.yandex.cupbackedn;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class First {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Double> map = new HashMap<>();
        double sum = 0.0;
        int count = 0;
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        boolean isContinue = true;
        while (isContinue) {
            line = reader.readLine();
            if (line.startsWith("+")) {
                String[] arr = line.split(" ");
                Integer id = Integer.parseInt(arr[1]);
                double temp = Double.parseDouble(arr[2]);
                map.put(id, temp);
                sum += temp;
                count++;
            } else if (line.equals("?")) {
                writer.write(String.valueOf(Math.round((sum / count) * 1000000000.0) / 1000000000.0));
                writer.newLine();
                writer.flush();
            } else if (line.startsWith("-")) {
                String[] arr = line.split(" ");
                Integer id = Integer.parseInt(arr[1]);
                Double oldValue = map.get(id);
                if (oldValue != null) {
                    sum -= oldValue;
                    count--;
                    map.remove(id);
                }
            } else if (line.startsWith("~")) {
                String[] arr = line.split(" ");
                Integer id = Integer.parseInt(arr[1]);
                double temp = Double.parseDouble(arr[2]);
                Double oldValue = map.get(id);
                if (oldValue != null) {
                    map.put(id, temp);
                    sum -= oldValue;
                    sum += temp;
                }

            } else if (line.equals("!")) {
                isContinue = false;
            }

        }
        reader.close();
        writer.close();
    }
}
