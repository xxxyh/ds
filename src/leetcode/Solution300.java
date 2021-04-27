package leetcode;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];//dp定义为以自己为结尾的最长上升子序列的长度，base为1
        // 这里数组初始化为0，结果应该加1
        for(int i = 1;i < nums.length;i++){
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int num : dp){
            max = Math.max(max, num);
        }
        return max + 1;//算上自己
    }

    public static void main(String[] args) {
        new Solution300().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }
}
