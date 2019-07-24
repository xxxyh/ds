package sort;

import java.util.Arrays;

public class RadixSort extends BaseSort{

    @Override
    public void sort(int[] nums){
        int length = getMaxDigit(nums);
        radixSort(nums, length);
    }

    private void radixSort(int[] nums, int length) {
        int mod = 10;
        int dev = 1;

        //例如最大的数是1253，则length=4，循环4次
        for(int i = 0;i < length;i++, dev *= 10, mod *= 10){
            //我的测试数组没负数，所以这里不考虑负数，如果这里要考虑负数的话，可以把counter改成int[mod * 2][0]
            //0-9为负数，10-19为非负数
            int[][] counter = new int[mod][0];

            for(int j = 0;j < nums.length;j++){
                int bucket = (nums[j] % mod) / dev;
                counter[bucket] = appendArray(counter[bucket], nums[j]);
            }

            int pos = 0;
            for(int[] bucket : counter){
                for(int value : bucket){
                    nums[pos++] = value;
                }
            }
        }

    }

    private int[] appendArray(int[] nums, int value) {
        //扩容一位，其实可以用List
        nums = Arrays.copyOf(nums, nums.length + 1);
        nums[nums.length - 1] = value;
        return nums;
    }

    private int getMaxDigit(int[] nums){
        int maxValue = getMaxValue(nums);
        int length = getNumberLength(maxValue);
        return length;
    }

    private int getNumberLength(int num) {
        if(num == 0){
            return 1;
        }
        int length = 0;
        for(int i = num; i > 0 ;i = i/10){
            length++;
        }
        return length;
    }

    private int getMaxValue(int[] nums) {
        int max = nums[0];
        int length = nums.length;
        for(int i = 1;i < length;i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new RadixSort().doSort();
    }
}
