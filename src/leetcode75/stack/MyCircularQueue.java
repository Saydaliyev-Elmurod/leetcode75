package leetcode75.stack;

class MyCircularQueue {
    int size;
    int count;
    int headIndex;
    int[] arr;

    public MyCircularQueue(int k) {
        this.size = k;
        arr = new int[k];
        count = 0;
    }

    public boolean enQueue(int value) {
        // handle full case
        if (isFull()) return false;
        // set the value
        // Given an array of size of 4, we can find the position to be inserted using the formula
        // targetIdx = (headIdx + cnt) % sz
        // e.g. [1, 2, 3, _]
        // headIdx = 0, cnt = 3, sz = 4, targetIdx = (0 + 3) % 4 = 3
        // e.g. [_, 2, 3, 4]
        // headIdx = 1, cnt = 3, sz = 4, targetIdx = (1 + 3) % 4 = 0
        arr[(headIndex + count) % size] = value;
        // increase the number of elements by 1
        count += 1;
        return true;
    }

    public boolean deQueue() {
        // handle empty case
        if (isEmpty()) return false;
        // update the head index
        headIndex = (headIndex + 1) % size;
        // decrease the number of elements by 1
        count -= 1;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return arr[headIndex];
    }

    public int Rear() {
        // handle empty queue case
        if (isEmpty()) return -1;
        // Given an array of size of 4, we can find the tailIdx using the formula
        // tailIdx = (headIdx + cnt - 1) % sz
        // e.g. [0 1 2] 3
        // headIdx = 0, cnt = 3, sz = 4, tailIdx = (0 + 3 - 1) % 4 = 2
        // e.g. 0 [1 2 3]
        // headIdx = 1, cnt = 3, sz = 4, tailIdx = (1 + 3 - 1) % 4 = 3
        // e.g. 0] 1 [2 3
        // headIdx = 2, cnt = 3, sz = 4, tailIdx = (2 + 3 - 1) % 4 = 0
        return arr[(headIndex + count - 1) % size];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */