package leetcode;

public class Solution410 {
    public int splitArray(int[] nums, int m) {
        int lo = getMax(nums);
        int hi = getSum(nums) + 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int n = split(nums, mid);
            if(n == m){
                hi = mid;
            }else if(n < m){//mid > res
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int split(int[] nums, int max) {
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            if (sum + num > max) {
                sum = num;
                count++;
            } else {
                sum += num;
            }
        }
        return count;
    }

    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
