package sort;

public class SimpleSort extends BaseSort {

    @Override
    public  void sort(int[] nums){
        int length = nums.length;
        int i=1;
        while(i < length){
            int temp = nums[i];
            int k = i -1;
            while(k >= 0 && nums[k] > temp){
                nums[k + 1] = nums[k];
                k--;
            }
            nums[k + 1] = temp;
            i++;
        }
    }

    public static void main(String[] args) {
        new SimpleSort().doSort();
    }

}
