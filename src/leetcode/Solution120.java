package leetcode;

import java.util.Arrays;
import java.util.List;

public class Solution120 {
    int[][] dp = null;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        return minimumTotal(triangle, 0, 0);
    }

    private int minimumTotal(List<List<Integer>> triangle, int level, int index){
        if(dp[level][index] != 0){
            return dp[level][index];
        }
        if(level == triangle.size() - 1){
            return triangle.get(level).get(index);
        }
        int left = minimumTotal(triangle, level + 1, index);
        int right = minimumTotal(triangle, level + 1, index + 1);
        int result = Math.min(left, right) + triangle.get(level).get(index);
        dp[level][index] = result;
        return result;
    }

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(2);
        List<Integer> l2 = Arrays.asList(3,4);
        List<Integer> l3 = Arrays.asList(6,5,7);
        List<Integer> l4 = Arrays.asList(4,1,8,3);
        List<List<Integer>> list = Arrays.asList(l1, l2, l3, l4);
        System.out.println(new Solution120().minimumTotal(list));
    }
}
