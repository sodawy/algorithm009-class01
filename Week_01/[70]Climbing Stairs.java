package Week_01;//You are climbing a stair case. It takes n steps to reach to the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top? 
//
// Note: Given n will be a positive integer. 
//
// Example 1: 
//
// 
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;

//Space Complexity: O(1)
//Time Complexity O(N)
// f(n) = f(n-1) + f(n-2)
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] a = new int[n];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;

        for(int i = 3; i < n - 1; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
