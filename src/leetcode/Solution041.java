package leetcode;

public class Solution041 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0;i < n;i++){
            if(nums[i] <= 0){
                nums[i] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0;i < n;i++){
            int cur = Math.abs(nums[i]);
            if(cur <= n && nums[cur - 1] > 0){//如果不考虑当前n个数刚好是1-n的话，这个没出现的正整数 - 1一定小于n，所以cur > n的可以不用考虑了
                nums[cur - 1] *= -1;      //当前n个数刚好是1-n的话，结果就是最后的n + 1
            }
        }

        for(int i = 0;i < n;i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        new Solution041().firstMissingPositive(new int[]{1});
    }
}
