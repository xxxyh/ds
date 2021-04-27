package leetcode;

public class Solution514 {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        char[] r = ring.toCharArray();
        char[] k = key.toCharArray();
        int[][] dp = new int[m][n];
        for(int i = 0;i < n;i++){
            if(r[i] == k[0]){
                dp[0][i] = Math.min(i, n - i) + 1;
            }
        }
        for(int i = 1;i < m;i++){
            for(int j = 0;j < n;j++){
                if(r[j] == k[i]){
                    //当前扭到j的位置
                    int min = Integer.MAX_VALUE;
                    for(int c = 0;c < n;c++){
                        if(dp[i - 1][c] != 0){
                            int len = dp[i - 1][c] + Math.min(Math.min(Math.abs(c - j), n + j - c), n + c - j) + 1;
                            min = Math.min(len, min);
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            if(dp[m - 1][i] != 0){
                min = Math.min(dp[m - 1][i], min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution514().findRotateSteps("edcba", "abcde"));
    }
}
