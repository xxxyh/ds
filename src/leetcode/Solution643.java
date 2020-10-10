package leetcode;

public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length < k){
            return 0;
        }
        int sum = 0;
        for(int i = 0;i < k;i++){
            sum += nums[i];
        }
        int max = sum;
        for(int i = k;i < nums.length;i++){
            sum = sum + nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return ((double)max)/k;
    }

    public static void main(String[] args) {
        System.out.println(new Solution643().findMaxAverage(new int[]{0,4,0,3,2}, 1));
    }
}
