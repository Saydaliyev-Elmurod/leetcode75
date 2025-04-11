package leetcode75.yandex.spring;

import java.io.*;
import java.util.*;

public class Three {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        int N = Integer.parseInt(line[0]); // actions
        int L = Integer.parseInt(line[1]); // length circle
        int S = Integer.parseInt(line[2]);  // speed

        Map<Integer, Integer> taxiPositions = new HashMap<>();

        List<String> results = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] arr = reader.readLine().split(" ");
            String action = arr[0];
            int timestamp = Integer.parseInt(arr[1]);
            if (action.equals("TAXI")) {
                int taxiId = Integer.parseInt(arr[2]);
                int taxiPosition = Integer.parseInt(arr[3]);
                taxiPositions.put(taxiId, taxiPosition);
            } else if (action.equals("ORDER")) {
                int orderId = Integer.parseInt(arr[2]);
                int orderPosition = Integer.parseInt(arr[3]);
                int orderTime = Integer.parseInt(arr[4]);

                List<Integer> availableTaxis = new ArrayList<>();

                for (Map.Entry<Integer, Integer> entry : taxiPositions.entrySet()) {
                    int taxiId = entry.getKey();
                    int taxiPosition = entry.getValue();

                    int distance = (orderPosition >= taxiPosition) ?
                            (orderPosition - taxiPosition) :
                            (L - taxiPosition + orderPosition);

                    int time = distance / S;

                    if (time <= orderTime) {
                        availableTaxis.add(taxiId);
                    }
                }

                if (availableTaxis.isEmpty()) {
                    results.add("-1");
                } else {
                    Collections.sort(availableTaxis);
                    StringBuilder result = new StringBuilder();
                    for (int j = 0; j < Math.min(availableTaxis.size(), 5); j++) {
                        if (j > 0) result.append(" ");
                        result.append(availableTaxis.get(j));
                    }
                    results.add(result.toString());
                }
            }
        }


        for (String result : results) {
            writer.write(result + "\n");
        }

        writer.close();
        reader.close();
    }
}
