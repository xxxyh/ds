package sort;

public class MergeSort extends BaseSort{

    @Override
    public void sort(int[] nums){
        int low = 0;
        int high = nums.length - 1;
        mergeSort(nums, low, high);
    }

    private void mergeSort(int[] nums, int low , int high){
        if(low < high){
            int mid = (low + high)/2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private void merge(int[] nums, int low, int mid, int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        //right从mid+1开始
        int[] right = new int[n2];
        for(int i = 0;i < n1;i++){
            left[i] = nums[low + i];
        }
        for(int i = 0;i < n2;i++){
            right[i] = nums[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = low;
        //有一个合并完了就退出
        while(i < n1 && j < n2){
            if(left[i] > right[j]){
                nums[k++] = right[j++];
            }else{
                nums[k++] = left[i++];
            }
        }
        while(i < n1){
            nums[k++] = left[i++];
        }
        while(j < n2){
            nums[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        new MergeSort().doSort();
    }
}
