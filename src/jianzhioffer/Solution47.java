package jianzhioffer;

public class Solution47 {
    public int maxValue(int[][] grid) {
        int n = grid.length;
        if(n == 0){
            return 0;
        }
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(i > 0 && j > 0){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }else if(j > 0){
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }else if(i > 0){
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }else{
                    dp[0][0] = grid[0][0];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
