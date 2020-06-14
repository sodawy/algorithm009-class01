import java.util.ArrayList;
import java.util.List;

class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        _sub(nums, ret, list, 0);
        return ret;
    }


    private void _sub(int[] nums, List<List<Integer>> ret, List<Integer> list, int start){
        ret.add(new ArrayList<>(list));
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            _sub(nums, ret, list, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Subset subset = new Subset();
        int[] input = new int[]{1, 2, 3};
        List<List<Integer>> subsets = subset.subsets(input);
        for (List<Integer> list : subsets) {
            for(Integer i:list){
                System.out.print(i + ",");
            }
            System.out.println("");
        }

    }
}