package sort;

public abstract class BaseSort {

    public void init(){
        String className = this.getClass().getSimpleName();
        System.out.println(className);
    }

    public abstract void sort(int[] nums);

    public void doSort(){
        int[] nums = SortUtils.generateIntArr();
        init();
        print(nums);
        this.sort(nums);
        print(nums);
    }

    private static void print(int[] nums){
        for(int num : nums){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
