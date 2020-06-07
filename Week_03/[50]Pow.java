class Pow{
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;

        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }

        if(n < 0) {
            n = -n;
            x = 1 / x;
        };

        return n % 2 == 1 ? x * myPow(x * x, n / 2) : myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.printf(String.valueOf(pow.myPow(2.00000, -2147483648)));
    }
}