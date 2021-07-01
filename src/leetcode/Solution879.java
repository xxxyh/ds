package leetcode;

public class Solution879 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = 1000000007;
        int[][][] dp = new int[profit.length + 1][minProfit + 1][n + 1];
        dp[0][0][0] = 1;
        for(int i = 1;i <= profit.length;i++){
            for(int j = minProfit;j >= 0;j--){
                for(int k = n;k >= 0;k--){
                    dp[i][j][k] = dp[i - 1][j][k];
                    if(group[i - 1] <= k){
                        dp[i][j][k] += dp[i - 1][Math.max(j - profit[i - 1], 0)][k - group[i - 1]];
                        dp[i][j][k] %= mod;
                    }
                }
            }
        }
        long res = 0L;
        for(int k = 0;k <= n;k++){
            res += dp[group.length][minProfit][k];
        }
        return (int)(res % mod);
    }

    public static void main(String[] args) {
        System.out.println(new Solution879().profitableSchemes(5,3,new int[]{2,2}, new int[]{2,3}));
    }
}
