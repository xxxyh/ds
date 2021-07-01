package jianzhioffer;

public class Solution10to1 {
    public int fib(int n) {
        int dp1 = 0;
        int dp2 = 1;
        for(int i = 1;i <= n;i++){
            int tmp = (dp1 + dp2) % 1000000007;
            dp1 = dp2;
            dp2 = tmp;
        }
        return dp1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution10to1().fib(95));
    }
}
