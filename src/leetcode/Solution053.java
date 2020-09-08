package leetcode;

public class Solution053 {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int[] dp = new int[2];
        dp[0] = nums[0];
        for(int i = 1;i< nums.length;i++){
            dp[1] = Math.max(dp[0], 0) + nums[i];
            result = Math.max(dp[1], result);
            dp[0] = dp[1];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution053().maxSubArray(new int[]{1}));
    }
}
