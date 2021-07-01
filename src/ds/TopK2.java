package ds;

import sort.SortUtils;

public class TopK2 {
    public static int topK(int[] nums, int k){
        if(k > nums.length || k <= 0){
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        k = nums.length - k;
        while(true){
            int p = partition(nums, lo, hi);
            if(p < k){
                lo = p + 1;
            }else if(p > k){
                hi = p - 1;
            }else{
                return nums[p];
            }
        }
    }

    public static int partition(int[] nums, int lo, int hi){
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
            SortUtils.swap(nums, i, j);
        }
        SortUtils.swap(nums, lo ,j);
        return j;
    }

    public static void main(String[] args) {
        System.out.println(topK(new int[]{1,2,3,4,5}, 3));
    }
}
