package leetcode;

public class Solution941 {
    public boolean validMountainArray(int[] A) {
        if(A == null || A.length < 3){
            return false;
        }
        int i = 0;
        while(i < A.length - 1 && A[i] < A[i + 1]){
             i++;
        }
        int max = i;
        while(i < A.length - 1){
            if(A[i] <= A[i + 1]){
                return false;
            }
            i++;
        }
        return max != 0 && max != A.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution941().validMountainArray(new int[]{0,3,2,1}));
    }
}
