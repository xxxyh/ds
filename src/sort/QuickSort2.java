package sort;

public class QuickSort2 extends BaseSort{
    @Override
    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int lo, int hi){
        if(lo >= hi){
            return;
        }
        int temp = nums[lo];
        int i = lo;
        int j = hi;
        while(i <j){
            while(i < j && nums[j] > temp){
                j--;
            }
            if(i < j){
                nums[i] = nums[j];
                i++;
            }
            while(i < j && nums[i] < temp){
                i++;
            }
            if(i < j){
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = temp;
        quickSort(nums, lo, i - 1);
        quickSort(nums, i + 1, hi);
    }

    public static void main(String[] args) {
        new QuickSort2().doSort();
    }
}
