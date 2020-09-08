package leetcode;

public class Solution050 {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(Math.abs(n) == 1){
            return n > 0 ? x : 1.0d/x;
        }
        if(Math.abs(Math.abs(x) - 1) < 0.000001){
            return n % 2 == 0 ? x * x : x;
        }
        boolean revert = false;
        if(n < 0){
            revert = true;
            n = Math.abs(n);
        }
        double d = x;
        while(n % 2 == 0){
            d *= d;
            n /= 2;
        }
        x = d;
        for(int i = 1;i < n;i++){
            d = d * x;
        }
        return revert ? 1.0d/d : d;
    }

    public static void main(String[] args) {
        System.out.println(new Solution050().myPow(2.00000, -2));
    }
}
