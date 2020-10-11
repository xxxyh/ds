package zhousai;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution5505 {
    long res = 0;
    public int maxSumRangeQuery(int[] nums, int[][] requests) {

        dfs(nums, new HashSet<>(), new ArrayList<>(), requests);
        return (int) (res % (1000000000 + 7));
    }

    private void dfs(int[] nums, Set<Integer> used, List<Integer> current, int[][] request){
        if(nums.length == current.size()){
            int[] preSum = new int[current.size() + 1];
            preSum[0] = 0;
            for(int i = 0;i < current.size();i++){
                preSum[i + 1] = preSum[i] + current.get(i);
            }

            long sum = 0;
            for(int[] req : request){
                int start = req[0];
                int end = req[1];
                sum += preSum[end + 1] - preSum[start];
            }
            res = Math.max(res, sum);
        }

        for(int i = 0;i < nums.length;i++){
            if(used.contains(i)){
                continue;
            }
            used.add(i);
            current.add(nums[i]);
            dfs(nums, used, current, request);
            used.remove(i);
            current.remove(current.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[][] request = {{1, 3},{0, 1}};
        System.out.println(new Solution5505().maxSumRangeQuery(new int[]{1,2,3,4,5}, request));
    }
}
