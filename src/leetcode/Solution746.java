package leetcode;

public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length < 2){
            return 0;
        }
        int dp0 = cost[0];
        int dp1 = cost[1];
        for(int i = 2;i < cost.length;i++){
            int tmp = Math.min(dp0, dp1) + cost[i];
            dp0 = dp1;
            dp1 = tmp;
        }
        return Math.min(dp0, dp1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution746().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
