package sort;

/**
 * @Author: xyh
 * @Date: 2019/7/23 15:26
 */
public class ShellSort extends BaseSort{
    @Override
    public void sort(int[] nums){
        int length = nums.length;
        int gap = 1;
        while(gap < length){
            gap = gap * 3 + 1;
        }
        while(gap > 0){
            for(int i = gap;i < length;i++){
                int temp = nums[i];
                int j = i - gap;
                //插入排序，找到小于temp的节点的下标j,然后j+gap就是temp的插入位置
                while( j >= 0 && nums[j] > temp){
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = temp;
            }
            gap = gap / 3;
        }
    }

    public static void main(String[] args) {
        new ShellSort().doSort();
    }
}
