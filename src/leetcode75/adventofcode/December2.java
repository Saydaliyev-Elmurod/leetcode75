package leetcode75.adventofcode;

import java.io.*;
import java.util.*;

public class December2 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        int answerOne = 0;
        int answerTwo = 0;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            String[] arr = line.split(" ");
            int last = Integer.parseInt(arr[0]);
            boolean isIncrease = last < Integer.parseInt(arr[1]);
            boolean isCorrect = false;
            boolean firstRemoved = false;
            // part 1
//            for (int i = 1; i < arr.length; i++) {
//                int current = Integer.parseInt(arr[i]);
//                if ((isIncrease && current - last >= 1 && current - last <= 3)
//                        || (!isIncrease && last - current >= 1 && last - current <= 3)) {
//                    isCorrect = true;
//                    last = current;
//                } else {
//                    isCorrect = false;
//                    break;
//                }
//            }
            //part 2
            for (int i = 1; i < arr.length; i++) {
                int current = Integer.parseInt(arr[i]);
                if ((isIncrease && current - last >= 1 && current - last <= 3)
                        || (!isIncrease && last - current >= 1 && last - current <= 3)) {
                    isCorrect = true;
                    last = current;
                } else {

                    if (firstRemoved) {
                        isCorrect = false;
                        break;
                    }
                    firstRemoved = true;
                }
            }


            if (isCorrect) {
                answerTwo++;
            } else {
                if (method(arr)) {
                    answerTwo++;
                }
            }
        }
        System.out.println("Answer one " + answerOne);
        System.out.println("Answer answerTwo " + answerTwo);
        // second part
        writer.close();
        reader.close();
    }

    private static boolean method(final String[] arr) {
        final List<String> list = Arrays.stream(arr).toList();
        for (int i = 0; i < arr.length; i++) {
            List<String> item = new ArrayList<>(list);
            item.remove(item.get(i));
            int last = Integer.parseInt(item.get(0));
            boolean isIncrease = last < Integer.parseInt(item.get(1));
            boolean isCorrect = false;
            for (int j = 1; j < item.size(); j++) {
                int current = Integer.parseInt(item.get(j));
                if ((isIncrease && current - last >= 1 && current - last <= 3)
                        || (!isIncrease && last - current >= 1 && last - current <= 3)) {
                    isCorrect = true;
                    last = current;
                } else {
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect) {
                return true;
            }
        }
        return false;
    }
}
