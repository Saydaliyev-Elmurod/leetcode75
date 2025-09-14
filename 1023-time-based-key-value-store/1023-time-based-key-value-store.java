
class TimeMap {
    Map<String, PriorityQueue<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        PriorityQueue<Data> queue = map.computeIfAbsent(
                key,
                s -> new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp));
        queue.add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        PriorityQueue<Data> queue = map.getOrDefault(key, new PriorityQueue<>());
        if (queue.isEmpty())
            return "";
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
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */