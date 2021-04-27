package leetcode;

public class Solution766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        if(n == 0){
            return true;
        }
        int m = matrix[0].length;
        for(int i = 0;i < n;i++){
            int cur = matrix[i][0];
            int col = 1;
            int row = i + 1;
            while(col < m && row < n){
                if(matrix[row][col] != cur){
                    return false;
                }
                col++;
                row++;
            }
        }

        for(int i = 1;i < m;i++){
            int cur = matrix[0][i];
            int col = i + 1;
            int row = 1;
            while(col < m && row < n){
                if(matrix[row][col] != cur){
                    return false;
                }
                col++;
                row++;
            }
        }
        return true;
    }

}
