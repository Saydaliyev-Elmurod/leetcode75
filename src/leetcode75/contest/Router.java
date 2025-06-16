package leetcode75.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import java.util.*;

class Router {
    LinkedList<Packet> queue;
    HashMap<String, Packet> map;
    int memoryLimit;
    HashMap<Integer, TreeMap<Integer, List<Packet>>> destinationMap;

    public Router(int memoryLimit) {
        queue = new LinkedList<>();
        map = new HashMap<>();
        this.memoryLimit = memoryLimit;
        this.destinationMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "," + destination + "," + timestamp;
        Packet packet = map.get(key);
        if (packet == null) {
            if (queue.size() >= memoryLimit) {
                final Packet poll = queue.poll();
                map.remove(poll.source + "," + poll.destination + "," + poll.timestamp);

                TreeMap<Integer, List<Packet>> destMap = destinationMap.get(poll.destination);
                if (destMap != null) {
                    List<Packet> packets = destMap.get(poll.timestamp);
                    if (packets != null) {
                        packets.removeIf(p -> p.source == poll.source);
                        if (packets.isEmpty()) {
                            destMap.remove(poll.timestamp);
                        }
                    }
                    if (destMap.isEmpty()) {
                        destinationMap.remove(poll.destination);
                    }
                }
            }

            final Packet newPacket = new Packet(source, destination, timestamp);
            map.put(key, newPacket);
            queue.add(newPacket);

            destinationMap
                    .computeIfAbsent(destination, k -> new TreeMap<>())
                    .computeIfAbsent(timestamp, k -> new ArrayList<>())
                    .add(newPacket);

            return true;
        } else {
            return false;
        }
    }

    private String getKeyPart(final int source, final int timestamp) {
        return source + "," + timestamp;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];
        Packet packet = queue.poll();
        String key = packet.source + "," + packet.destination + "," + packet.timestamp;
        map.remove(key);

        TreeMap<Integer, List<Packet>> destMap = destinationMap.get(packet.destination);
        if (destMap != null) {
            List<Packet> packets = destMap.get(packet.timestamp);
            if (packets != null) {
                packets.removeIf(p -> p.source == packet.source);
                if (packets.isEmpty()) {
                    destMap.remove(packet.timestamp);
                }
            }
            if (destMap.isEmpty()) {
                destinationMap.remove(packet.destination);
            }
        }

        return new int[]{packet.source, packet.destination, packet.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        TreeMap<Integer, List<Packet>> destMap = destinationMap.get(destination);
        if (destMap == null) return 0;

        return destMap.subMap(startTime, true, endTime, true)
                .values()
                .stream()
                .mapToInt(List::size)
                .sum();
    }

    public static class Packet implements Comparable<Packet> {
        public int source;
        public int destination;
        public int timestamp;

        @Override
        public String toString() {
            return source + " " + destination + " " + timestamp;
        }

        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public int compareTo(final Packet o) {
            return 0;
        }
    }
}
