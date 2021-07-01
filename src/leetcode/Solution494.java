package leetcode;

public class Solution494 {
    /**
     * sum(P) 前面符号为+的集合；sum(N) 前面符号为减号的集合
     * 所以题目可以转化为
     * sum(P) - sum(N) = target
     * => sum(nums) + sum(P) - sum(N) = target + sum(nums)
     * => 2 * sum(P) = target + sum(nums)
     * => sum(P) = (target + sum(nums)) / 2
     * 因此题目转化为01背包，也就是能组合成容量为sum(P)的方式有多少种
     */

    /**
     * p = (sum - target) / 2，sum从加p到减p成为target，减少了2P，也就是减掉的数字加起来为p
     * w = sum - p = (sum + target) / 2，也就是前面是加号的数字加起来为w,万千背包
     */

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum +=num;
        }
        if(sum < target || ((target + sum) & 1) != 0){//target和sum同偶或者同奇，相加必为偶数
            return 0;
        }

        int w = (sum + target) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for(int num : nums){
            for(int i = w;i >= num;i--){
                dp[i] += dp[i - num];
            }
        }
        return dp[w];
    }
}
