package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(nums1.length);
        Set<Integer> set2 = new HashSet<>(nums2.length);
        for(int num : nums1){
            set1.add(num);
        }
        for(int num : nums2){
            set2.add(num);
        }
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int index = 0;
        for(int num : set1){
            res[index++] = num;
        }
        return res;
    }
}
