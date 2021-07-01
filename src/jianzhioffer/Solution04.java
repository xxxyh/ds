package jianzhioffer;

public class Solution04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0){
            return false;
        }
        int m = matrix[0].length;
        int j = m - 1;
        int i = 0;
        while(j >=0 && i < n){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else if(matrix[i][j] < target){
                i++;
            }
        }
        return false;
    }
}
