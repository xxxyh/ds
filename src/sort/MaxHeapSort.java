package sort;

/**
 * 堆排序(大顶堆)
 * @author 方珂
 * @create 2019-07-22 14:45
 */
public class MaxHeapSort extends BaseSort{

    @Override
    public void sort(int[] nums) {
        int length = nums.length;
        buildMaxHeap(nums,length);
        for (int i = length - 1; i > 0; i--){
            swap(nums, 0, i);
            length --;
            heapify(nums, 0 , length);
        }
    }

    private void buildMaxHeap( int[] nums, int length){
        for (int i = (int) Math.floor(length/2); i >= 0 ; i--){
            heapify(nums,i,length);
        }
    }

    /**
     * 数组入堆
     */
    private void heapify(int[] nums, int i, int length){
        int right = 2 * i + 1;
        int left = 2 * i + 2;
        int largest = i;
        if (left <length && nums[left] > nums[largest]){
            largest = left;
        }
        if (right <length && nums[right] > nums[largest]){
            largest = right;
        }
        if (largest != i) {
            swap(nums,largest,i);
        }
    }

    public static void main(String[] args) {
        new MaxHeapSort().doSort();
    }
}
