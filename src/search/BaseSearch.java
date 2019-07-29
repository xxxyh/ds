package search;

import java.util.Random;

public abstract class BaseSearch {

    public void init(){
        String className = this.getClass().getSimpleName();
        System.out.println(className);
    }

    public abstract boolean search(int[] nums, int data);

    public void doSearch(int data){
        int[] nums = generateIntArr();
        init();
        print(nums);
        System.out.println("查找data:"+data);
        System.out.println(search(nums, data));
    }

    public void doSearch(int[] nums, int data){
        init();
        print(nums);
        System.out.println("查找data:"+data);
        System.out.println(search(nums, data));
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
