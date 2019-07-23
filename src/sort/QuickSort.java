package sort;

public class QuickSort extends BaseSort {

    @Override
    public void sort(int[] nums){
        int low = 0;
        int high = nums.length - 1;
        quickSort(nums, low, high);
    }

    private void quickSort(int[] nums, int low, int high){
        if(low < high){
            int i = low;
            int j = high;
            int temp = nums[low];
            while(i < j){
                while(i < j && nums[j] > temp){
                    j--;
                }
                if(i < j){
                    nums[i] = nums[j];
                    i++;
                }
                while(i<j && nums[i] < temp){
                    i++;
                }
                if(i < j){
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = temp;
            quickSort(nums, low, i - 1);
            quickSort(nums, i + 1, high);
        }
    }

    public static void main(String[] args) {
        new QuickSort().doSort();
    }
}
