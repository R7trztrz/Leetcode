package Leetcode.DataStructure.CycleArray.DesignCircularDeque;

/**Move forward: (index + 1) % n
 * Move backward: (index - 1 + n) % n
 *
 * @since 23 / 06 / 2026
 */
class MyCircularDeque {
    private int[] data;
    private int size;

    private int head;
    private int tail;


    public MyCircularDeque(int k) {
        data = new int[k];
        size = 0;

        head = 0;
        tail = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            // [head, tail)
            head = (head - 1 + data.length) % data.length;
            data[head] = value;
            size++;
        }

        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            data[tail] = value;
            // [head, tail)
            tail = (tail + 1) % data.length;
            size++;
        }

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            head = (head + 1) % data.length;
            size--;
        }

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            tail = (tail - 1 + data.length) % data.length;
            size--;
        }

        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return data[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return data[(tail - 1 + data.length) % data.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}
