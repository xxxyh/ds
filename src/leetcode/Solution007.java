package leetcode;

public class Solution007 {

    public int reverse(int x) {
        long val = 0L;
        while(x != 0){
            int k = x % 10;
            val *= 10;
            val += k;
            x /= 10;
        }
        if(val > Integer.MAX_VALUE || val < Integer.MIN_VALUE){
            return 0;
        }else{
            return (int)val;
        }
    }
}
