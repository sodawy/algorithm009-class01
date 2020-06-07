import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class PickIndex {
    Random random;
    int[] sumW;
    int len;

    PickIndex(int[] w) {
        random = new Random();
        len = w.length;

        if(len < 1){
            return;
        }

        sumW = new int[len];
        sumW[0] = w[0];
        for(int i = 1; i < len; i++){
            sumW[i] = w[i] + sumW[i - 1];
        }
    }

    public int pickIndex() {
        int idx = random.nextInt(this.sumW[this.len - 1]) + 1;
        int ret = Arrays.binarySearch(this.sumW, idx);
        return ret > 0 ? ret : -ret-1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,3};
        PickIndex pickIndex = new PickIndex(input);
        System.out.println(pickIndex.pickIndex());
    }
}