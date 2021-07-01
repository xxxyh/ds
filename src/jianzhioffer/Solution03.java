package jianzhioffer;

import java.util.HashSet;
import java.util.Set;

public class Solution03 {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        for(int i = 0;i < n;i++){
            while(i != nums[i]){
                if(nums[nums[i]] == nums[i]){
                    return nums[i];
                }
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution03().findRepeatNumber(new int[]{3, 1, 0, 2, 5, 3}));
    }
}
