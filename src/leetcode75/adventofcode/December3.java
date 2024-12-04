package leetcode75.adventofcode;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class December3 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        long result = 0L;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            Pattern pattern = Pattern.compile("\\b(?:don't\\(\\)|do\\(\\)|mul\\((\\d{1,33}),(\\d{1,33})\\))\\b\n");
            Matcher matcher = pattern.matcher(line);
            boolean lastIsDont = false;
            while (matcher.find()) {
                String group = matcher.group();
                if (group.equals("don't()")) {
                    lastIsDont = true;
                } else if (group.equals("do()")) {
                    lastIsDont = false;
                } else {
                    if (lastIsDont){
                        group = group.substring(4);
                        group = group.substring(0, group.length() - 1);
                        final String[] split = group.split(",");
                        System.out.println(split[0] + "xxx" + split[1]);
                        result += (long) Integer.parseInt(split[0]) * Integer.parseInt(split[1]);
                    }

                }

            }

        }
        System.out.println("Matches: " + result);


    }
}
