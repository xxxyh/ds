package sort;

import static sort.SortUtils.swap;

public class BubbleSort extends BaseSort {

    @Override
    public void sort(int[] nums){
        int n = nums.length;
        for(int i = 0;i < n;i++){
            boolean flag = true;
            for(int j = 0;j< n - i - 1;j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j ,j+1);
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

    public static void main(String[] args) {
        new BubbleSort().doSort();
    }
}
