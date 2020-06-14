import java.util.*;

class Permutaions {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null) return ret;
        boolean[] used = new boolean[nums.length];
        Stack<Integer> stack = new Stack<>();
        _helper(ret, used, stack, nums);
        return ret;
    }

    private void _helper(List<List<Integer>> ret, boolean[] used, Stack<Integer> stack, int[] nums) {
        if (stack.size() == nums.length) {
            ret.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] != true) {
                used[i] = true;
                stack.push(nums[i]);
                _helper(ret, used, stack, nums);
                stack.pop();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutaions permutaions = new Permutaions();
        int[] input = new int[]{1, 2, 3};
        List<List<Integer>> permute = permutaions.permute(input);
        for (List<Integer> list : permute) {
            StringBuilder sb = new StringBuilder();
            for (Integer in : list) {
                sb.append(in);
            }
            System.out.println(sb.toString());
        }
    }
}