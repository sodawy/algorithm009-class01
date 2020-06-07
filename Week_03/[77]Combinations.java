import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        _helper(ret, new Stack<>(), 1, n, k);
        return ret;
    }

    private void _helper(List<List<Integer>> list, Stack<Integer> stack, int begin, int end, int capacity) {
        if (stack.size() == capacity) {
            list.add(new ArrayList<>(stack));
            return;
        }

        int neededSize = capacity - stack.size();
        for (int i = begin; i <= end - neededSize + 1; i++) {
            stack.push(i);
            _helper(list, stack, i + 1, end, capacity);
            stack.pop();
        }
    }
}