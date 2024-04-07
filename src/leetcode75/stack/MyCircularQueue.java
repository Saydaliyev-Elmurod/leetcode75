package leetcode75.stack;

class MyCircularQueue {
    /**
     * Queue data structure
     * Navbat desak boladi
     * First Input First OutPut
     */

    // bu queue size boladi va u o'zgarmas
    int size;
    // bu queue head  index yana chiqib kirish uchun turgan element
    int headIndex;
    // bu queuedagi elementlar soni
    int count;
    int[] arr;

    public MyCircularQueue(int k) {
        // k size ga ega array yaratamiz
        arr = new int[k];
        this.size = k;// queue o'lchamini size ga tenglashtiramiz
        count = 0; // queue yaratilganda elementlar soni 0 ta boladi
    }

    public boolean enQueue(int value) {
        // Queue ga yangi element qoshilyapti
        if (isFull()) return false;
        // Queue ga insert qilishdan oldin
        // Queue arrayning qaysi index isiga insert bolishini aniqlab olishimiz kerak
        // headIndex (arrayning boshi) va count ta element bor bizda
        // keyingi element headIndex+count indexga joylashishi kerak
        // lekin hIndex+count arraynign sizedan oshib ketishi mumkin
        // agar oshib ketsa arrayning boshiga insert qilinishi kerak agar tolmasa
        // index = (headIndex+count)%size
        // [_,_,3,4,5] -> 1 -> headIndex = 2; count = 3;size = 5 ; index = (5%5)=0;
        // [1,_,3,4,5] -> 7 -> headIndex = 2; count = 4 ;size = 5 ; index = (6%5)=1;
        arr[(headIndex + count) % size] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        // queue dan element ni o'chirish
        // element ni null ga aylantirish  kerak lekin primitive tip bolgani uchun
        // null ga aylantira olmaymiz
        // headIndex bittaga oshib ketadi lekin headIndex
        // arrayning oxirida bolsa arrayning boshiga qaytishi kerak
        // [1,2,3] ->[_,2,3] ->[_,_,3]  headIndex = 2
        // insert qilamiz
        // [4,_,3] headIndex = 2 ochiramiz [4,_,_] headIndex = 0;
        if (isEmpty()) return false;
        headIndex = (headIndex + 1) % size;
        count--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return arr[headIndex];
    }

    public int Rear() {
        if (isEmpty()) return -1;
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