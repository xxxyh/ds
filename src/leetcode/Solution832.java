package leetcode;

public class Solution832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        if(n == 0){
            return A;
        }
        int m = A[0].length;
        for(int i = 0;i < n;i++){
            int p = 0;
            int q = m - 1;
            while(p <= q){
                int pVal = A[i][p] ^ 1;
                int qVal = A[i][q] ^ 1;
                A[i][p] = qVal;
                A[i][q] = pVal;
                p++;
                q--;
            }
        }
        return A;
    }

    public static void main(String[] args) {
    }
}
