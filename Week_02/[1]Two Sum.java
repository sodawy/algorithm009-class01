import java.util.HashMap;

class TwoSum{
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return null;
        }

        int[] ret = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                ret[0] = map.get(target - nums[i]);
                ret[1] = i;
                return ret;
            }else{
                map.put(nums[i], i);
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "we are you";
        System.out.println(s.replaceAll(" ", "%20"));
    }
}