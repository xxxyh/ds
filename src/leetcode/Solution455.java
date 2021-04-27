package leetcode;

import java.util.Arrays;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        int sum = 0;
        for(int i = 0;i < g.length;i++){
            if(index >= s.length){
                break;
            }
            while(index < s.length && g[i] > s[index++]){
            }
            if(g[i] <= s[index - 1]){
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution455().findContentChildren(new int[]{1,2,3}, new int[]{3}));
    }
}
