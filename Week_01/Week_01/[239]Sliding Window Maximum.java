package Week_01;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return null;
        }

        Deque<Integer> q = new ArrayDeque<>(k);

        int len = nums.length;
        int[] ret = new int[len - k + 1];
        int retIndex = 0;

        for (int i = 0; i < len; i++) {
            //remove out of k range
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }

            //monotonous increased queue
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            q.offer(i);

            if (i >= k - 1) {
                ret[retIndex++] = nums[q.peek()];
            }
        }

        return ret;

    }
}