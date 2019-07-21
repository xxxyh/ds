package sort;

public class SimpleSort extends BaseSort {

    @Override
    public  void sort(int[] nums){
        int length = nums.length;
        int i=1;
        while(i < length){
            int temp = nums[i];
            int k = i -1;
            boolean flag = true;
            while(k >= 0){
                if(nums[k] > temp){
                    nums[k+1] = nums[k];
                }else{
                    nums[k+1] = temp;
                    flag = false;
                    break;
                }
                k--;
            }
            //如果一直没插入temp,说明temp比nums[0]还小
            if(flag){
                nums[0] = temp;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        new SimpleSort().doSort();
    }

}
