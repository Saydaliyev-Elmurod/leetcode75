package leetcode75.yandex.cup;

import java.io.*;

public class First {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer t = Integer.valueOf(reader.readLine());

        while (t-- > 0) {
            Integer n = Integer.valueOf(reader.readLine());
            String[] arr = reader.readLine().split(" ");
            int res = 0;
            if (n < 3) {
                res = 0;
            }else{
                res = calculate(arr);
            }
            writer.write(String.valueOf(res));
        }


        reader.close();
        writer.close();
    }

    private static int calculate(final String[] arr) {
        int left = 0;
        int right = 2;

return 5;
    }
}
