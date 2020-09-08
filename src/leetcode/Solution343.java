package leetcode;

public class Solution343 {
    public static int integerBreak(int n) {
        int[] dp = new int[n];
        for(int i = 0;i < n;i++){
            dp[i] = -1;
        }
        if(n == 3){
            return 2;
        }
        if(n == 2){
            return 1;
        }
        return execute(n, dp);
    }
    private static int execute(int n, int[] dp){
        if(n < 0){
            return 0;
        }
        if(n < 2){
            return 1;
        }
        if(dp[n - 2] != -1){
            return dp[n - 2];
        }
        int left = execute(n - 2, dp) * 2;
        int right = execute(n - 3, dp) * 3;
        return dp[n - 2] = Math.max(left, right);
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
