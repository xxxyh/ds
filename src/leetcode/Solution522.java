package leetcode;

public class Solution522 {
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length < 2) {
            return A;
        }
        int[] res = new int[A.length];
        int i = 0;
        int j = 1;
        for (int a : A) {
            if (a % 2 == 0) {
                res[i] = a;
                i += 2;
            } else {
                res[j] = a;
                j += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution522().sortArrayByParityII(new int[]{2, 3});
    }
}
