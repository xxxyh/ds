package leetcode;

import java.util.Arrays;

public class Solution1723 {
    int res = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        long start = System.currentTimeMillis();
        int[] cur = new int[k];
        dfs(jobs, cur, 0, k);
        long end = System.currentTimeMillis();
        return res;
    }

    private void dfs(int[] jobs, int[] cur, int index, int k){
        if(index == jobs.length){
            int max = 0;
            for(int i = 0;i < cur.length;i++){
                max = Math.max(cur[i], max);
            }
            res = Math.min(max, res);
            return;
        }
        int value = jobs[index];
        for(int i = 0;i < k;i++){
            cur[i] += value;
            dfs(jobs, cur, index + 1, k);
            cur[i] -= value;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1723().minimumTimeRequired(new int[]{11,15,8,16,5,10,2,13,1}, 5));
    }

}
