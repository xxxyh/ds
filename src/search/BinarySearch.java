package search;

public class BinarySearch extends BaseSearch {


    @Override
    public boolean search(int[] nums, int data) {
        int low = 0;
        int high = nums.length - 1;
        return binarySearch(nums, data, low, high);
    }

    public boolean binarySearch(int[] nums, int data, int low, int high){
        if(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] > data){
                return binarySearch(nums, data, low, mid - 1);
            }else if(nums[mid] < data){
                return binarySearch(nums, data, mid + 1, high);
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2 , 3, 4, 5, 6, 7, 8, 9};
        new BinarySearch().doSearch(nums, 1);
    }
}
