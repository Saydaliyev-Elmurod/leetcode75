package leetcode75.hashMapSet.designHashSet;

class MyHashSet {
    private Integer[] arr;

    public MyHashSet() {
        arr = new Integer[1000000+1];
    }

    public void add(int key) {
        arr[key] = key;
    }

    public void remove(int key) {
        arr[key] = null;
    }

    public boolean contains(int key) {
        return arr[key] != null;
    }
}