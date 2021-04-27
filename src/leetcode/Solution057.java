package leetcode;

import java.util.Arrays;

public class Solution057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] intervals2 = new int[intervals.length + 1][2];
        if(intervals.length == 0){
            intervals2[0] = newInterval;
            return intervals2;
        }
        int index = 0;
        boolean flag = true;
        for(int[] interval : intervals){
            if(flag && interval[0] > newInterval[0]){//先插入
                intervals2[index++] = newInterval;
                flag = false;
            }
            intervals2[index++] = interval;
        }
        if(flag){
            intervals2[index++] = newInterval;
        }
        return merge(intervals2);
    }

    //56题
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[0][2];
        }
        //在56题的基础上去掉排序，因为这一题本来就排好序了，只要把新区间找个位置插进来O(N)，排序太慢了
        //Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

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
