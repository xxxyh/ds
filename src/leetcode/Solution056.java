package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution056 {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[][] res = new int[intervals.length][2];
        res[0] = intervals[0];
        int index = 0;
        for(int i = 1;i < intervals.length;i++){
            int[] interval = intervals[i];
            int end = res[index][1];
            if(interval[0] <= end){//x合并y,y.start <= x.end;
                res[index][1] = Math.max(interval[1], end);
            }else{
                res[++index] = interval;
            }
        }
        return Arrays.copyOf(res, index + 1);
    }
}
