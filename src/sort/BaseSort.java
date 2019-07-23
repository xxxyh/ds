package sort;

public abstract class BaseSort {

    public void init(){
        String className = this.getClass().getSimpleName();
        System.out.println(className);
    }

    public abstract void sort(int[] nums);

    public void doSort(){
        int[] nums = new int[]{9,1,2,7,1,3,2,1,10,11,12,99,123,23};
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

    public static void print(int[] nums){
        for(int num : nums){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
