package search;

public class SequelSearch extends BaseSearch {


    @Override
    public boolean search(int[] nums, int data) {
        int n = nums.length;
        for(int i = 0;i < n;i++){
            if(nums[i] == data){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new SequelSearch().doSearch(10);
    }
}
