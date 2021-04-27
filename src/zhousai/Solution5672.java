package zhousai;

public class Solution5672 {
    public boolean check(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return true;
        }
        int i = 1;
        for(;i < n;i++){
            if(nums[i] < nums[i - 1]){
                break;
            }
        }
        if(i == n){
            return true;
        }
        i++;
        for(;i < n;i++){
            if(nums[i] < nums[i - 1]){
                break;
            }
        }
        if(nums[0] < nums[n - 1]){
            return false;
        }
        return i >= n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution5672().check(new int[]{1,1,1}));
    }
}
