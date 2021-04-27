package leetcode;

public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0 || k == 0){
            return 0;
        }
        int[][] in = new int[n][k];
        int[][] out = new int[n][k];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < k;j++){
                in[i][j] = Integer.MIN_VALUE;
                out[i][j] = Integer.MIN_VALUE;
            }
        }
        in[0][0] = 0 - prices[0];
        out[0][0] = 0;
        for(int i = 1;i < n;i++){
            int cur = Math.min(i / 2 + 1, k);
            for(int j = 0;j < cur;j++){
                in[i][j] = in[i - 1][j];
                if(j == 0){
                    in[i][j] = Math.max(in[i][j], 0 - prices[i]);
                }
                if(j > 0){
                    in[i][j] = Math.max(in[i][j], out[i - 1][j - 1] - prices[i]);
                }
                out[i][j] = Math.max(out[i - 1][j], in[i - 1][j] + prices[i]);
            }
        }
        int max = 0;
        for(int i = 0;i < k;i++){
            max = Math.max(max, out[n - 1][i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution188().maxProfit(2,new int[]{1,2,4,7}));
    }
}
