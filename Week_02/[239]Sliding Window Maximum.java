import java.util.ArrayDeque;
import java.util.Deque;

class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) {
            return null;
        }

        int len = nums.length;
        int[] ret = new int[len - k + 1];
        int retIndex = 0;

        Deque<Integer> deque = new ArrayDeque<>(k);

        for (int i = 0; i < len; i++) {
            if (!deque.isEmpty() && i - deque.peek() >= k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                ret[retIndex++] = nums[deque.peek()];
            }
        }

        return ret;
    }
}