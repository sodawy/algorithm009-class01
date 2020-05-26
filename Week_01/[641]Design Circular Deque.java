package Week_01;

import java.util.ArrayDeque;
import java.util.Deque;

class MyCircularDeque {
    final Deque<Integer> _q;
    final int cap;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        _q = new ArrayDeque<>(k);
        cap = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (this.isFull()) {
            return false;
        }
        return _q.offerFirst(value);
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (this.isFull()) {
            return false;
        }
        return _q.offer(value);
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (_q.isEmpty()) {
            return false;
        } else {
            _q.poll();
            return true;
        }
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (_q.isEmpty()) {
            return false;
        } else {
            _q.pollLast();
            return true;
        }
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (_q.isEmpty()) {
            return -1;
        } else {
            return _q.peek();
        }
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (_q.isEmpty()) {
            return -1;
        } else {
            return _q.peekLast();
        }
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return _q.isEmpty();
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return _q.size() == this.cap;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */