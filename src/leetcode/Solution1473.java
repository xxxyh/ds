package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution1473 {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < m;i++){
            if(houses[i] != 0){
                set.add(houses[i]);
            }
        }
        if(set.size() > target || target > m){
            return -1;
        }
        int[][][] dp = new int[m][n][target];//前m个房子当前颜色为n构成target个街区需要的最小花费

        if(houses[0] == 0){
            for(int i = 0;i < n;i++){
                dp[0][i][0] = cost[0][i];
            }
        }
        for(int i = 1;i < m;i++){
            if(houses[i] != 0){//无法改变颜色
                //和前一个房子颜色相同
                dp[i][houses[i]] = dp[i - 1][houses[i]];
                continue;
            }
            for(int j = 0;j < Math.min(i,n);j++){//前i个房子最多只能构成i个颜色
                for(int k = 0;k < Math.min(j, target);k++){//前j个房子最多只能构成j个街区
                    if(k == 0){
                        dp[i][j][k]= dp[i - 1][j][k] + cost[i][j];
                    }else{
                        dp[i][j][k] = Math.min(dp[i - 1][j][k], dp[i - 1][j][k - 1]) + cost[i][j];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            min = Math.min(min, dp[m - 1][i][target - 1]);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1473().minCost(new int[]{0,0,0,0,0},
                new int[][]{{1,10},{10,1},{10,1},{1,10},{5,1}},
                5, 2, 3));
    }
}
