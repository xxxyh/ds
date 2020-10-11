package zhousai;

import java.util.Arrays;

public class Solution5531 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1;i <= nums.length;i++){
            for(int j = 0;j < nums.length;j++){
                if(nums[j] >= i){
                    int len = nums.length - j;
                    if(i == len){
                        return i;
                    }else{
                        break;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution5531().specialArray(new int[] {0,4,3,0,4}));
    }
}
