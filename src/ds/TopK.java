package ds;

import sort.SortUtils;

public class TopK {
    public int topK(int[] nums, int k){
        int lo = 0;
        int hi = nums.length - 1;
        k = nums.length - k;
        while(lo <= hi){
            int p = partition(nums, lo, hi);
            if(p == k){
                return nums[p];
            } else if(p < k){
                lo = p + 1;
            }else{
                hi = p - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new TopK().topK(SortUtils.generateIntArr(), 3));
    }

    private int partition(int[] nums, int lo, int hi){
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
        SortUtils.swap(nums, lo, j);
        return j;
    }

}
