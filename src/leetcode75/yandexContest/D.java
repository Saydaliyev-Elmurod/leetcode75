import java.io.*;
import java.util.HashSet;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int position = Integer.parseInt(reader.readLine());
        String line = reader.readLine();
        int a = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < line.length() - 1; i++) {
            char charAt = line.charAt(i);
            String s1 = line.substring(0, i), s2 = line.substring(0, i);
            if (charAt == 'R') {
                s1 += 'L';
                s2 += 'F';

            } else if (charAt == 'L') {
                s1 += 'R';
                s2 += 'F';

            } else {
                s1 += 'R';
                s2 += 'L';
            }
            if (i != line.length() - 1) {
                s1 += line.substring(i + 1);
                s2 += line.substring(i + 1);
            }
            set.add(findPosition(s1, position));
            set.add(findPosition(s2, position));

        }
        writer.write(String.valueOf(set.size()));
        reader.close();
        writer.close();
    }

    private static Integer findPosition(String line, Integer position) {
        int a = 1;
        for (int i = 0; i < line.length(); i++) {
            char charAt = line.charAt(i);
            if (charAt == 'R') {
                a = 1;
            } else if (charAt == 'L') {
                a = -1;
            } else {
                position += a;
            }
        }
        return position;
    }
}
