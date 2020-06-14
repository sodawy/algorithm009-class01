import java.util.*;

class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null) return ret;

        //must sort, so that we can pruning
        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];
        Deque<Integer> deque = new ArrayDeque<>(nums.length);

        dfs(ret, used, deque, nums);

        return ret;
    }

    private void dfs(List<List<Integer>> ret, boolean[] used, Deque<Integer> deque, int[] nums) {
        if (deque.size() == nums.length) {
            ret.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            //nums[i-1] is identical nums[i], and we already finished that condition`s calculate
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }

            deque.addLast(nums[i]);
            used[i] = true;

            dfs(ret,used,deque,nums);

            used[i] = false;
            deque.removeLast();

        }
    }

    public static void main(String[] args) {
        Permutations2 permutations2 = new Permutations2();
        int[] input = new int[]{1, 1, 2};
        List<List<Integer>> permute = permutations2.permuteUnique(input);
        for (List<Integer> list : permute) {
            StringBuilder sb = new StringBuilder();
            for (Integer in : list) {
                sb.append(in);
            }
            System.out.println(sb.toString());
        }
    }
}