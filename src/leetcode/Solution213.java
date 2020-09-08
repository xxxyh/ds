package leetcode;

public class Solution213 {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        if(n <= 3){
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        //拆成两块，一块是0到n-1，一块是1到n
        int[] dp = new int[n - 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2;i < n - 1;i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int left = dp[n - 2];

        dp[0] = nums[1];
        dp[1] = Math.max(nums[1], nums[2]);
        for(int i = 3;i < n;i++){
            dp[i - 1] = Math.max(dp[i - 3] + nums[i], dp[i - 2]);
        }
        return Math.max(left, dp[n - 2]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution213().rob(new int[]{1,3,1,3,100}));
    }
}
