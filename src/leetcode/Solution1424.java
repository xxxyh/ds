package leetcode;

import java.util.Arrays;
import java.util.List;

public class Solution1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        return null;
    }
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,2,3);
        List<Integer> l2 = Arrays.asList(4,5,6);
        List<Integer> l3 = Arrays.asList(7,8,9);
        List<List<Integer>> nums = Arrays.asList(l1, l2, l3);
        System.out.println(new Solution1424().findDiagonalOrder(nums));
    }
}
