package test.hello;

public class RotateTest {//找出旋转数组中的最小值

    public static int test(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = (start + end)/2;
            if(nums[mid] > nums[end]){
                start = mid + 1;
            }else if(nums[mid] < nums[end]){
                end = mid;
            }else{
                return minOfArray(nums, start, end);
            }
        }
        return nums[start];
    }

    private static int minOfArray(int[] nums, int start, int end){
        int min = nums[start];
        for(int i = start + 1; i <= end;i++){
            if(nums[i] < min){
                min = nums[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,5,1};
        System.out.println(test(nums));
    }
}
