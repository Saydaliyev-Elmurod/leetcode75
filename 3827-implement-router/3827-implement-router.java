class Router {
    int memory;
    HashSet<String> set;
    Queue<int[]> queue;
    HashMap<Integer, List<Integer>> destinations;

    public Router(int memoryLimit) {
        memory = memoryLimit;
        set = new HashSet<>();
        queue = new LinkedList<>();
        destinations = new HashMap<>();

    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "/" + destination + "/" + timestamp;
        if (set.contains(key))
            return false;

        if (queue.size() == memory) {
            int[] old = queue.poll();
            set.remove(old[0] + "/" + old[1] + "/" + old[2]);
            List<Integer> pack = destinations.get(old[1]);
            if (pack != null) {
                pack.remove(Integer.valueOf(old[2]));
                if (pack.isEmpty()) {
                    destinations.remove(old[1]);
                }
            }
        }

        set.add(key);
        queue.add(new int[] { source, destination, timestamp });

        List<Integer> packets = destinations.getOrDefault(destination, new ArrayList<>());
        packets.add(timestamp);
        destinations.put(destination, packets); // ✅ qaytadan map’ga qo‘yish kerak

        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty())
            return new int[] {};
        int[] old = queue.poll();
        set.remove(old[0] + "/" + old[1] + "/" + old[2]);
        List<Integer> pack = destinations.get(old[1]);
        pack.remove(Integer.valueOf(old[2]));
        if (pack.isEmpty()) {
            destinations.remove(old[1]);
        }
        return old;
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> packets = destinations.getOrDefault(destination, new ArrayList<>());
        int start = lowerBound(packets, startTime);
        int end = upperBound(packets, endTime);
        return end - start;
    }

    private int lowerBound(List<Integer> list, int val) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) < val) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l; // birinchi >= val bo‘lgan index
    }

    private int upperBound(List<Integer> list, int val) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) <= val) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l; // birinchi > val bo‘lgan index
    }

}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */