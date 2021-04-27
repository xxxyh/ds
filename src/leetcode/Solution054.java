package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution054 {
    int n = 0;
    int m = 0;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        n = matrix.length;
        if(n == 0){
            return res;
        }
        m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        dfs(matrix, 0, 0, 0, visited, res);
        return res;
    }

    //tag 0向右 1向左 2向上 3向下
    private void dfs(int[][] matrix, int i, int j, int tag, boolean[][] visited, List<Integer> res){
        res.add(matrix[i][j]);
        visited[i][j] = true;
        if(tag == 0){//向右
            if(canVisit(i, j + 1, visited)){//继续向右
                dfs(matrix, i, j + 1, 0, visited, res);
            }else if(canVisit(i + 1, j, visited)){//向下
                dfs(matrix, i + 1, j, 3, visited, res);
            }
        }

        if(tag == 1){//向左
            if(canVisit(i, j - 1, visited)){//继续向左
                dfs(matrix, i, j - 1, 1, visited, res);
            }else if(canVisit(i - 1, j, visited)){//向上
                dfs(matrix, i - 1, j, 2, visited, res);
            }
        }

        if(tag == 2){//向上
            if(canVisit(i - 1, j, visited)){//继续向上
                dfs(matrix, i - 1, j, 2, visited, res);
            }else if(canVisit(i, j + 1, visited)){//向右
                dfs(matrix, i, j + 1, 0, visited, res);
            }
        }

        if(tag == 3){//向下
            if(canVisit(i + 1, j, visited)){//继续向下
                dfs(matrix, i + 1, j, 3, visited, res);
            }else if(canVisit(i, j - 1, visited)){//向左
                dfs(matrix, i, j - 1, 1, visited, res);
            }
        }
    }


    private boolean canVisit(int i, int j, boolean[][] visited){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }

        return !visited[i][j];
    }
}
