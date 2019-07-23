package sort;

import java.util.Random;

public abstract class BaseSort {

    public void init(){
        String className = this.getClass().getSimpleName();
        System.out.println(className);
    }

    public abstract void sort(int[] nums);

    public void doSort(){
        int[] nums = generateIntArr();
        init();
        print(nums);
        this.sort(nums);
        print(nums);
    }

    public static void swap(int[] nums, int  i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void print(int[] nums){
        for(int num : nums){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    private int[] generateIntArr(){
        Random random = new Random();
        //产生一个10-30的随机数
        int length = random.nextInt(20) + 10;

        int[] nums = new int[length];
        for(int i = 0;i < length;i++){
            nums[i] = random.nextInt(30);
        }
        return nums;
    }
}
