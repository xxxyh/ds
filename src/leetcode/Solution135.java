package leetcode;

public class Solution135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] nums = new int[n];
        nums[0] = 1;
        for(int i = 1;i < n;i++){
            if(ratings[i] > ratings[i - 1]){
                nums[i] = nums[i - 1] + 1;
            }else {
                nums[i] = 1;
            }
        }

        for(int i = n - 2;i >= 0;i--){
            if(ratings[i] > ratings[i + 1] && nums[i] <= nums[i + 1]){
                nums[i] = nums[i + 1] + 1;
            }
        }
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution135().candy(new int[]{1,3,2,2,1}));
    }
}
