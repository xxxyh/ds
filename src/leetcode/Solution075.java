package leetcode;

import java.util.Arrays;

public class Solution075 {
    public void sortColors(int[] nums) {
        int rs = 0, bs = 0;
        for(int i = 0;i < nums.length - bs;i++){
            if(nums[i] == 0){//红色
                nums[i] = nums[rs];
                nums[rs] = 0;
                rs++;
            }
            if(nums[i] == 2){//蓝色
                nums[i] = nums[nums.length - bs - 1];
                nums[nums.length - bs - 1] = 2;
                bs++;
                if(nums[i] != 1){
                    i--;
                }
            }
        }
        for(int i = rs + 1;i < nums.length - bs;i++){
            nums[i] = 1;
        }
    }

    public static void main(String[] args) {
        new Solution075().sortColors(new int[]{1,2,0});
    }

}
