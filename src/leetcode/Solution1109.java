package leetcode;

import ds.Difference;

public class Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] p = new int[n];
        Difference difference = new Difference(p);
        for(int[] booking : bookings){
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            difference.increment(i, j, booking[2]);
        }
        return difference.result();
    }
}
