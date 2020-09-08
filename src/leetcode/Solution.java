package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums2){
            numSet.add(num);
        }
        int len = nums1.length > nums2.length ? nums1.length : nums2.length;
        List<Integer> list = new ArrayList<>();
        for(int num : nums1){
            if(numSet.contains(num)){
                list.add(num);
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for(Integer num : list){
            result[i++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(intersect(nums1, nums2));
    }
}
