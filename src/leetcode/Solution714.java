package leetcode;

public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;//不持有股票
        dp[0][1] = 0 - prices[0];//持有股票

        for(int i = 1;i < n;i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }

    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int dp0 = 0;//不持有股票
        int dp1 = 0 - prices[0];//持有股票

        for(int i = 1;i < n;i++){
            dp0 = Math.max(dp0, dp1 + prices[i] - fee);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }
        return dp0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution714().maxProfit2(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
