package leetcode;

import java.util.Arrays;

public class Solution322to2 {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1;i <= amount;i++){
            for(int coin : coins){
                if(i < coin){
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        if(dp[amount] == amount + 1){
            return -1;
        }
        return dp[amount];
    }

}
