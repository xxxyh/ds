package leetcode;

import java.util.Arrays;

public class Solution453 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2)-> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int res = 0;
        int end = Integer.MIN_VALUE;
        for(int i = 0;i < intervals.length;i++){
            int[] interval = intervals[i];
            if(interval[0] < end){
                res++;
                end = Math.min(end, interval[1]);
            }else{
                end = interval[1];
            }
        }
        return res;
    }
}
