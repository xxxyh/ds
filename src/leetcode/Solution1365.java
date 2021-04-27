package leetcode;

public class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if(n == 0){
            return res;
        }
        int[] cur = new int[101];
        for(int i = 0;i < n;i++){
            cur[nums[i]]++;
        }
        int[] preSum = new int[101];
        int sum = 0;
        for(int i = 0;i < 101;i++){
            sum += cur[i];
            preSum[i] = sum;
        }
        for(int i = 0;i < n;i++){
            if(nums[i] == 0){
                res[i] = 0;
                continue;
            }
            res[i] = preSum[nums[i] - 1];
        }
        return res;
    }
}
