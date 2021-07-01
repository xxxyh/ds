package leetcode;

import java.util.Arrays;

public class Solution279 {
    public int numSquares(int n) {
        if(n == 1){
            return 1;
        }
        int[] nums = new int[Math.min(100, n)];
        int sqrt = 0;
        while(sqrt * sqrt <= n){
            nums[sqrt] = sqrt * sqrt;
            sqrt++;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1;i < sqrt;i++){
            for(int j = nums[i];j <= n;j++){
                dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution279().numSquares(13));
    }
}
