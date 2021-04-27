package leetcode;

public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        int[] cur = new int[2001];
        for(int a : arr){
            cur[a + 1000]++;//从-1000开始，就把-1000转成0
        }
        int[] res = new int[n];
        for(int a : cur){
            if(a != 0){
                res[a]++;
                if(res[a] == 2){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution1207().uniqueOccurrences(new int[]{1,2,2,1,1,3});
    }
}
