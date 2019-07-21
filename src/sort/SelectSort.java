package sort;

public class SelectSort extends BaseSort{

    @Override
    public void sort(int[] nums){
        int i = 0;//无序序列的起始下标
        while(i < nums.length){
            int j = i;//无序序列中最小值的下标
            for(int k = i;k < nums.length;k++){
                if(nums[k] < nums[j]){
                    j = k;
                }
            }
            swap(nums, i, j);
            i++;
        }
    }
    public static void main(String[] args) {
        new SelectSort().doSort();
    }

}
