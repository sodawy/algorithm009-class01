package Week_01;

class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9){
                digits[i] += 1;
                return digits;
            }else{
                digits[i] = 0;

                if(i - 1 >= 0){
                    continue;
                }else{
                    int[] ret = new int[digits.length + 1];
                    ret[0] = 1;
                    int t = 1;
                    for(int num: digits){
                        ret[t++] = num;
                    }
                    return ret;
                }
            }
        }

        return null; //will never run to here
    }
}