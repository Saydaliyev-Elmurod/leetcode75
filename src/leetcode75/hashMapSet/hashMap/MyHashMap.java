package leetcode75.hashMapSet.hashMap;

class MyHashMap {
    private Integer[] arr;

    public MyHashMap() {
        arr = new Integer[1000001];
    }

    public void put(int key, int value) {
        arr[key] = value;
    }

    public int get(int key) {
        Integer val = arr[key];
        return val != null ? val : -1;
    }

    public void remove(int key) {
        arr[key] = null;
    }
}