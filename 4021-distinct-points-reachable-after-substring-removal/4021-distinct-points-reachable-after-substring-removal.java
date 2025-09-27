class Solution {
    public int distinctPoints(String s, int k) {
        if (k >= s.length()) {
            return 1;
        }
        int len = s.length();
        Map<Integer, int[]> map = new HashMap<>();
        int x = 0;
        int y = 0;
        Set<String> points = new HashSet<>();
        map.put(0, new int[] { 0, 0 });
        for (int i = 0; i < len; i++) {
            switch (s.charAt(i)) {
                case 'L' -> x--;
                case 'R' -> x++;
                case 'D' -> y--;
                case 'U' -> y++;
            }
            map.put(i + 1, new int[] { x, y });
        }

        for (int i = 0; i <= len - k; i++) {
            int[] p1 = map.get(i);
            int[] p2 = map.get(i + k);
            int tx = x - (p2[0] - p1[0]);
            int ty = y - (p2[1] - p1[1]);
            points.add(tx + "/" + ty);
            System.out.println(tx + "?" + ty);
        }
        return points.size();
    }
}