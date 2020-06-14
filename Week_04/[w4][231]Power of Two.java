class PowerOfTwo{
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;

        while(n != 2){
            if(n % 2 > 0) return false;

            n /= 2;


        }
        return true;
    }

    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        System.out.println(powerOfTwo.isPowerOfTwo(218));


    }
}