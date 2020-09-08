package leetcode;

public class Solution303 {

    private int[] presum;

    private Solution303(int[] nums){
        int N = nums.length;
        presum = new int[N + 1];

        presum[0] = 0;
        for(int i = 0;i < N;i++){
            presum[i + 1] = presum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j){
        return presum[j + 1] - presum[i];
    }
}
