package zhousai;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution5504 {

    public int minSubarray(int[] nums, int p) {
        long[] preSum = new long[nums.length + 1];
        preSum[0] = 0;
        for(int i = 0;i < nums.length;i++){
            preSum[i + 1] = preSum[i] + nums[i];
        }
        long sum = preSum[nums.length];

        for(int i = 0; i < nums.length;i++){
            boolean flag = dfs(nums, i, sum, p, preSum);
            if(flag){
                return i;
            }
        }
        return -1;
    }

    private boolean dfs(int[] nums, int total, long sum, int p, long[] preSum){
        for(int i = 0;i + total <= nums.length;i++){
            long current = sum;
            int end = i + total;
            current -= preSum[end] - preSum[i];
            if(current % p == 0){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution5504().minSubarray(new int[]{1000000000,1000000000,1000000000}, 3));
    }
}
