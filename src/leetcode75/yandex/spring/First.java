package leetcode75.yandex.spring;

import java.io.*;

public class First {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        final String[] line = reader.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int X = Integer.parseInt(line[2]);
        int Y = Integer.parseInt(line[3]);

        int[][] arr = new int[N * X][M * Y];

        for (int i = 0; i < N * X; i++) {
            String[] item = reader.readLine().split("");
            for (int j = 0; j < M * Y; j++) {
                arr[i][j] = item[j].equals("0") ? 0 : 1;
            }
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int tempCount = 0;

                for (int k = 0; k < X; k++) {
                    for (int l = 0; l < Y; l++) {
                        if (arr[i * X + k][j * Y + l] == 1) {
                            tempCount++;
                        }
                    }
                }

                if (tempCount >= (X * Y + 1) / 2) {
                    count++;
                }
            }
        }

        writer.write(String.valueOf(count));
        writer.close();
        reader.close();
    }
}
