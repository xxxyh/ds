package sort;

public class MinHeapSort extends BaseSort{

    @Override
    public void sort(int[] nums){
        int length = nums.length;
        buildMinHeap(nums, length);
        int size = length;
        for(int i = length - 1;i > 0;i--){
            swap(nums, i, 0);
            heapify(nums, 0, --size);
        }
    }

    private void buildMinHeap(int[] nums, int size){
        for(int i = size / 2; i >= 0;i--){
            heapify(nums, i, size);
        }
    }


    private void heapify(int[] nums, int currentNode, int size){
        int left = 2 * currentNode + 1;
        int right = 2* currentNode + 2;

        int min = currentNode;

        //找出以currentNode为根节点的三个节点的最小节点
        if(left < size && nums[left] < nums[min]){
            min = left;
        }

        if(right < size && nums[right] < nums[min]){
            min = right;
        }

        if(min != currentNode){
            swap(nums, min , currentNode);
            heapify(nums, min, size);
        }
    }


    public static void main(String[] args) {
        new MinHeapSort().doSort();
    }
}
