package ds;

public class MaxHeap {
    private int[] nums;
    private int cap;//容量
    private int size;

    public MaxHeap(int cap) {
        this.nums = new int[cap + 1];//下标为0的位置不存元素
        this.cap = cap;
        this.size = 0;
    }

    public void insert(int num) {
        if (size >= cap) {
            return;
        }
        size++;
        nums[size] = num;
        int i = size;
        while (i / 2 > 0 && nums[i / 2] < nums[i]) {
            swap(i, i / 2);
            i /= 2;
        }
    }

    public int removeMax() {
        if (size == 0) {
            return -1;
        }
        int removeMax = nums[1];
        nums[1] = nums[size];
        size--;
        heapify(size, 1);
        return removeMax;
    }

    public void heapify(int endIndex, int startIndex) {
        while (true) {
            int finalPos = startIndex;
            if (startIndex * 2 <= endIndex && nums[startIndex * 2] > nums[finalPos]) {
                finalPos = startIndex * 2;
            }
            if (startIndex * 2 + 1 <= endIndex && nums[startIndex * 2 + 1] > nums[finalPos]) {
                finalPos = startIndex * 2 + 1;
            }
            if (startIndex == finalPos) {
                break;
            }
            swap(finalPos, startIndex);
            startIndex = finalPos;
        }
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
