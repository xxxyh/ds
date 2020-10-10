package leetcode;

public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }
        int[] dp = new int[amount + 1];
        execute(coins, amount, dp);
        return dp[amount];
    }

    private int execute(int[] coins, int amount, int[] dp){
        if(amount < 0){
            return -1;
        }
        if(dp[amount] != 0){
            return dp[amount];
        }
        if(amount == 0){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int coin : coins){
            int cur = execute(coins, amount - coin, dp);
            if(cur == -1){
                continue;
            }
            res = Math.min(res, 1 + cur);
        }
        if(res == Integer.MAX_VALUE){
            res = -1;
        }
        return dp[amount] = res;
    }
}
