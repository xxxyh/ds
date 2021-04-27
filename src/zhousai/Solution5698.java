package zhousai;

public class Solution5698 {
    public int minElements(int[] nums, int limit, int goal) {
        int n = nums.length;
        long sum = 0;
        for(int i = 0;i < n;i++){
            sum += nums[i];
        }
        long diff = Math.abs(goal - sum);
        long res = diff % limit == 0 ? diff / limit : diff / limit + 1;
        return (int)res;
    }
}
