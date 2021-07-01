package leetcode;

public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            max = Math.max(nums[i], max);
        }
        int[] arr = new int[max + 1];
        for(int i = 0;i < nums.length;i++){
            arr[nums[i]]++;
        }
        int res = 0;
        int[] dp = new int[max + 1];
        dp[1] = arr[1];
        for(int i = 2;i < max + 1;i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i] * i);
        }
        return dp[max];
    }

    public static void main(String[] args) {
        System.out.println(new Solution740().deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
}
