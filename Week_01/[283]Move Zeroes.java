package Week_01;//Given an array nums, write a function to move all 0's to the end of it while m
//aintaining the relative order of the non-zero elements. 
//
// Example: 
//
// 
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0] 
//
// Note: 
//
// 
// You must do this in-place without making a copy of the array. 
// Minimize the total number of operations. 
// Related Topics Array Two Pointers


//leetcode submit region begin(Prohibit modification and deletion)
class MoveZeros {
//    public void moveZeroes(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return;
//        }
//
//        int nonZeroPos = -1;
//        for (int num : nums) {
//            if (num != 0) {
//                nums[nonZeroPos++] = num;
//            }
//        }
//
//        while (nonZeroPos < nums.length) {
//            nums[nonZeroPos++] = 0;
//        }
//    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int pos = 0; //non zero pos
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }
        while (pos < nums.length) {
            nums[pos++] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
