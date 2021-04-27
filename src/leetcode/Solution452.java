package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int res = 0;
        long end = Long.MIN_VALUE;
        for (int[] point : points) {
            if (point[0] > end) {
                end = point[1];
                res++;
            }else {
                end = Math.min(end, point[1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution452().findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}});
    }

}
