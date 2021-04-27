package leetcode;


public class Solution887 {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while(dp[K][m] < N){
            m++;
            for(int i = 1;i <= K;i++){
                dp[i][m] = dp[i][m - 1] + dp[i - 1][m - 1] + 1;
            }
        }
        return m;
    }

}
