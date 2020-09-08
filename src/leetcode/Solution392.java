package leetcode;

public class Solution392 {
    public static boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0){
            return true;
        }
        if(t == null || t.length() == 0){
            return false;
        }

        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int i = 0, j = 0;
        while(j < c2.length){
            if(c2[j] == c1[i]){
                i++;
            }
            j++;
            if(i == c1.length){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
