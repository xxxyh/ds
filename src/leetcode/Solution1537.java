package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1537 {
    Map<Integer, Long> dp = new HashMap<>();
    Map<Integer, Integer> map1 = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    public int maxSum(int[] nums1, int[] nums2) {
        for(int i = 0;i< nums1.length;i++){
            map1.put(nums1[i], i);
        }
        for(int i = 0;i< nums2.length;i++){
            map2.put(nums2[i], i);
        }
        long left = maxSum(nums1, nums2, nums1[0]);
        long right = maxSum(nums1, nums2, nums2[0]);
        long result = Math.max(left, right);
        return (int)result % (1000000007);
    }

    private long maxSum(int[] nums1, int[] nums2, int currentSum){
        if(dp.get(currentSum) != null){
            return dp.get(currentSum);
        }
        //1走完了，不能跳到2
        if(map1.get(currentSum) != null && map1.get(currentSum) == nums1.length - 1 && !map2.containsKey(currentSum)){
            dp.put(currentSum, Long.valueOf(currentSum));
            return currentSum;
        }
        //2走完了,不能跳到1
        if(map2.get(currentSum) != null && map2.get(currentSum) == nums2.length - 1 && !map1.containsKey(currentSum)){
            dp.put(currentSum, Long.valueOf(currentSum));
            return currentSum;
        }
        //刚好这个数是两个数组的结尾
        if(map1.get(currentSum) != null && map1.get(currentSum) == nums1.length - 1 && map2.get(currentSum) != null && map2.get(currentSum) == nums2.length - 1){
            dp.put(currentSum, Long.valueOf(currentSum));
            return currentSum;
        }
        long left = Long.MIN_VALUE;
        if(map1.get(currentSum) != null && map1.get(currentSum) + 1 < nums1.length){
            left = maxSum(nums1, nums2, nums1[map1.get(currentSum) + 1]);
        }
        long right = Long.MIN_VALUE;
        if(map2.get(currentSum) != null && map2.get(currentSum) + 1 < nums2.length){
            right = maxSum(nums1, nums2, nums2[map2.get(currentSum) + 1]);
        }
        long result = Math.max(left, right) + currentSum;
        dp.put(currentSum, result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,4,5,8,9,11,19};
        int[] nums2 = new int[]{2,3,4,11,12};
        System.out.println(new Solution1537().maxSum(nums1, nums2));
    }
}
