package leetcode;

public class Solution724 {

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        int A = 0;
        for(int i = 0;i < nums.length;i++){
            int x = nums[i];
            if(2 * A + x == sum){
                return i;
            }
            A += x;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(pivotIndex(nums));
    }
}
