package sort;

import java.util.Random;

public class SortUtils {
    private static final Random RANDOM = new Random();

    public static void swap(int[] nums, int  i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] generateIntArr(){
        //产生一个10-30的随机数
        int length = RANDOM.nextInt(20) + 10;

        int[] nums = new int[length];
        for(int i = 0;i < length;i++){
            nums[i] = RANDOM.nextInt(30);
        }
        return nums;
    }
}
