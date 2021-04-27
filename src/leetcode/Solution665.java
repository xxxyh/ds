package leetcode;

public class Solution665 {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if(n < 2){
            return true;
        }
        int res = 0;
        for(int i = 0;i < n - 1;i++){
            if(nums[i] > nums[i + 1]){//不满足
                if(i > 0){
                    if(nums[i] > nums[i - 1] && nums[i + 1] >= nums[i - 1]){//看能否调整i
                        nums[i] = nums[i - 1];
                    }else{
                        nums[i + 1] = nums[i];
                    }
                }else{
                    nums[i] = nums[i + 1];
                }
                res++;
            }
            if(res > 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution665().checkPossibility(new int[]{2,3,3,2,2}));
    }
}
