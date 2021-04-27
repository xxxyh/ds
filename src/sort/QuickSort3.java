package sort;

import static sort.SortUtils.swap;

public class QuickSort3 extends BaseSort {
    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        new QuickSort3().doSort();
    }

    private void sort(int[] nums, int lo, int hi){
        if(lo >= hi){
            return;
        }

        int p = partition(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi){
        if(lo == hi){
            return lo;
        }
        int temp = nums[lo];
        int i = lo;
        int j = hi + 1;
        while(true){
            while(nums[++i] < temp){
                if(i == hi){
                    break;
                }
            }
            while(nums[--j] > temp){
                if(j == lo){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo , j);
        return j;
    }
}
