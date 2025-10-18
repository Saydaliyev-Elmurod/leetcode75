package leetcode75.hashMapSet.longestrepeating;

import leetcode75.yandex.uzbcup.D;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class TimeMap {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1)); // return "bar"
        System.out.println(timeMap.get("foo", 3)); // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is returned.
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4)); // return "bar2"
        System.out.println(timeMap.get("foo", 5)); // return "bar2"
    }

    Map<String, PriorityQueue<Data>> map;


    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        PriorityQueue<Data> queue = map.computeIfAbsent(
                key,
                s -> new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp)
        );
        queue.add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        PriorityQueue<Data> queue = map.getOrDefault(key, new PriorityQueue<>());
        if (queue.isEmpty()) return "";
        PriorityQueue<Data> temp = new PriorityQueue<>(queue);
        while (!temp.isEmpty()) {
            Data data = temp.poll();
            if (data.timestamp <= timestamp) {
                return data.value;
            }
        }
        return "";

    }

    public static class Data {
        String value;
        Integer timestamp;

        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}