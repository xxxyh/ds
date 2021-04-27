package leetcode;

public class Solution977 {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int size = A.length - 1;
        int i = 0, j = A.length - 1;
        while(i <= j){
            if(Math.abs(A[i]) > Math.abs(A[j])){
                res[size--] = A[i] * A[i];
                i++;
            }else{
                res[size--] = A[j] * A[j];
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution977().sortedSquares(new int[]{-4,-1,0,3,10});
    }
}
