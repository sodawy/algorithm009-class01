class TrappingRainWater{
    public int trap(int[] height) {
        if(height == null || height.length <= 2){
            return 0;
        }

        int lMax = 0, rMax = 0;
        int left = 0, right = height.length - 1;
        int sum = 0;
        while(left < right){
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);
            if(lMax <= rMax){
                sum += lMax - height[left];
                left++;
            }else{
                sum += rMax - height[right];
                right--;
            }
        }

        return sum;
    }
}