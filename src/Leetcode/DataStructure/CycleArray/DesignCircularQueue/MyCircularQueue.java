package Leetcode.DataStructure.CycleArray.DesignCircularQueue;

/**
 *
 * @since 23 / 06 / 2026
 */
class MyCircularQueue {
    private int size;
    private int[] data;

    int head;
    int tail;

    public MyCircularQueue(int k) {
        size = 0;
        data = new int[k];
        head = 0;
        tail = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            data[tail] = value;
            // back to start of the array if tail reaches end of the array
            // [head, tail)
            tail = (tail + 1) % data.length;
            size++;
        }

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            head = (head + 1) % data.length;
            size--;
        }

        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[head];
        }
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            // back to end of the array if tail reaches head of the array
            return data[(tail - 1 + data.length) % data.length];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}
