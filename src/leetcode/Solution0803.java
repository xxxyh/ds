package leetcode;

public class Solution0803 {
    //每日一题
    public int findMagicIndex(int[] nums) {
        if(nums == null){
            return -1;
        }
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == i){
                return i;
            }
        }
        return -1;
    }
}
