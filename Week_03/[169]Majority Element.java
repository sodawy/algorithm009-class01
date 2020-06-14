class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null) return 0;

        int count = 1, majoy = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majoy)
                count++;
            else {
                if (count == 0) {
                    majoy = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }
        return majoy;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] input = new int[]{6,5,5};
        System.out.println(majorityElement.majorityElement(input));
    }
}