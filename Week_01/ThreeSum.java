package Week_01;

import java.util.*;

//[15]
public class ThreeSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        LinkedList<List<Integer>> lists = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int sum = 0 - nums[i];
                int lo = i + 1;
                int hi = nums.length - 1;
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        List<Integer> list = Arrays.asList(nums[i], nums[lo], nums[hi]);
                        lists.add(list);
                        while (lo < hi && nums[hi] == nums[--hi]) ;
                        while (lo < hi && nums[lo] == nums[++lo]) ;
                    } else if (nums[lo] + nums[hi] > sum) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            }
        }

        return new ArrayList<>(lists);
    }
}
