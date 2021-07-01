package jianzhioffer;

public class Solution14to1 {
    public int cuttingRope(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4;i <= n;i++){
            dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
        }
        return dp[n];
    }

    public int cuttingRope2(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int res = 1;
        while(n > 4){
            n -= 3;
            res *= 3;
        }
        return res * n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution14to1().cuttingRope2(10));
    }
}
