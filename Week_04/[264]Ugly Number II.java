class Ugly2{
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int ret = 0;
        int i = 0;
        int[] nums = new int[n];
        nums[i] = 1;

        while(i + 1 < n){
            ret = Math.min(nums[i2]*2, Math.min(nums[i3]*3, nums[i5]*5));
            if(ret == nums[i2]*2) i2++;
            if(ret == nums[i3]*3) i3++;
            if(ret == nums[i5]*5) i5++;

            nums[++i] = ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        Ugly2 ugly2 = new Ugly2();
        System.out.println(ugly2.nthUglyNumber(10));
    }
}