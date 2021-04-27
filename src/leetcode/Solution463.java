package leetcode;

public class Solution463 {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        if(grid == null || grid.length == 0){
            return res;
        }
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 1){
                    int size = 4;
                    if(i > 0 && grid[i - 1][j] == 1){
                        size -= 2;
                    }
                    if(j > 0 && grid[i][j - 1] == 1){
                        size -= 2;
                    }
                    res += size;
                }
            }
        }
        return res;
    }
}
