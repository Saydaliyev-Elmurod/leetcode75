class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                String str = valid(h, m, turnedOn);
                if (str != null) {
                    res.add(str);
                }
            }
        }
        return res;
    }

    public String valid(int h, int m, int turnedOn) {
        if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
            return h + ":" + ((m < 10) ? ("0" + m) : m);
        }
        return null;
    }
}