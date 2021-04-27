package leetcode;

import java.util.Arrays;

public class Solution638 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution638().maximumProduct(new int[]{-100,-98,-1,2,3,4}));
    }
}
