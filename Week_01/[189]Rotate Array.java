package Week_01;

import java.util.ArrayDeque;
import java.util.Deque;

class RotateArray{
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int len = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();

        if(k > len){
            k = k - len;
        }

        for(int i = 0; i < len - k; i++) {
            deque.addLast(nums[i]);
        }

        for(int j = len - 1; j >= len - k; j--) {
            deque.addFirst(nums[j]);
        }

        for(int t = 0; t < len; t++){
            nums[t] = deque.pollFirst();
        }
    }
}