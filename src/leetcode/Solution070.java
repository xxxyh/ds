package leetcode;

public class Solution070 {
    public int climbStairs(int n) {
        if(n < 3){
            return n;
        }
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 3;i <= n;i++){
            int c = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = c;
        }
        return dp[1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution070().climbStairs(3));
    }
}
