package leetcode75.yandexContest.revocup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String[] nums = reader.readLine().split(" ");
        int logCount = Integer.parseInt(nums[0]);
        int attempt = Integer.parseInt(nums[1]);
        int time = Integer.parseInt(nums[2]);
        HashMap<String, Queue<Integer>> lastAttempt = new HashMap<>();
        HashSet<String> users = new HashSet<>();

        while (logCount-- > 0) {
            String[] line = reader.readLine().split(" ");
            int logTime = Integer.parseInt(line[0]);
            String username = line[1];
            String action = line[2];
            if (action.equals("FAIL")) {
                if (!users.contains(username)) {
                    Queue<Integer> lastLogTime = lastAttempt.getOrDefault(username, new ArrayDeque<>());
                    while (!lastLogTime.isEmpty() && logTime - lastLogTime.peek() > time) {
                        lastLogTime.poll();
                    }
                    lastLogTime.add(logTime);
                    if (lastLogTime.size() >= attempt) {
                        users.add(username);
                    }
                    lastAttempt.put(username, lastLogTime);
                }
            }
        }
        if (users.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(users.stream().sorted().collect(Collectors.joining("\n")));
        }

        reader.close();
    }

}

