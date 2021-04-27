package leetcode;

public class Solution1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 1;
        int count = 0;
        int right = 0;
        for(;right < nums.length;right++){
            if(nums[right] % 2 != 0){//奇数
                count++;
            }
            if(count == k){
                break;
            }
        }
        if(count < k){
            return 0;
        }
        int left = 0;
        right++;
        while(right < nums.length){
            if(nums[right] % 2 != 0){
                while(nums[left] % 2 == 0){
                    left++;
                }
                res++;
            }
            right++;
        }
        return res;
    }
}
