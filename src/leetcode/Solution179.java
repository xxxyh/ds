package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution179 {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int num : nums){
            list.add(String.valueOf(num));
        }
        list.sort(new Comparator<String>() {
            @Override public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String num : list){
            sb.append(num);
        }
        int i = 0;
        for(;i < sb.length() - 1;i++){
            if(sb.charAt(i) != '0'){
                break;
            }
        }
        return sb.substring(i, sb.length());
    }

    public static void main(String[] args) {
        System.out.println(new Solution179().largestNumber(new int[]{0,0, 0}));
    }
}
