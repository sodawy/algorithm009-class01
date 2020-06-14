import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubSet2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) return null;

        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        _sub(ret, list, nums, 0);
        return ret;
    }

    private void _sub(List<List<Integer>> ret, List<Integer> list, int[] nums, int start) {
        ret.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]){
                continue;
            };
            list.add(nums[i]);
            _sub(ret, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSet2 subset = new SubSet2();
        int[] input = new int[]{4,4,4,1,4};
        List<List<Integer>> subsets = subset.subsetsWithDup(input);
        for (List<Integer> list : subsets) {
            for (Integer i : list) {
                System.out.print(i + ",");
            }
            System.out.println("");
        }

    }
}