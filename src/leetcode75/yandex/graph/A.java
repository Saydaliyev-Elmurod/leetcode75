package leetcode75.yandex.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(reader.readLine());
    List<Interval> intervals = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String[] line = reader.readLine().split("-");
      Interval interval = new Interval(line[0], line[1]);
      intervals.add(interval);
    }
    intervals =
        intervals.stream()
            .sorted(
                (a, b) -> {
                  if (a.start.equals(b.start)) {
                    return a.end.compareTo(b.end);
                  } else {
                    return a.start.compareTo(b.start);
                  }
                })
            .toList();
    int m = Integer.parseInt(reader.readLine());
    List<Interval> returnIntervals = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      String[] line = reader.readLine().split("-");
      Interval interval = new Interval(line[0], line[1]);
      returnIntervals.add(interval);
    }
    returnIntervals =
        intervals.stream()
            .sorted(
                (a, b) -> {
                  if (a.start.equals(b.start)) {
                    return a.end.compareTo(b.end);
                  } else {
                    return a.start.compareTo(b.start);
                  }
                })
            .toList();

    reader.close();
    writer.close();
  }

  public static class Interval {
    String start;
    String end;

    public Interval(String start, String end) {
      this.start = start;
      this.end = end;
    }
  }
}
