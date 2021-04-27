package leetcode;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_0 = 0, dp_1 = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, -prices[i]);
        }
        return dp_0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution121().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
