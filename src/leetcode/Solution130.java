package leetcode;

public class Solution130 {
    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        int m = board.length;//高
        int n = board[0].length;//宽
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(i == 0 || j == 0 || i == m - 1 || j == n - 1){
                    dfs(board, i, j);
                }
            }
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i == board.length || j == board[0].length
                || board[i][j] == 'X' || board[i][j] == '#'){
            return;
        }
        board[i][j] = '#';
        dfs(board, i + 1, j);//向上
        dfs(board, i - 1, j);//向下
        dfs(board, i, j + 1);//向右
        dfs(board, i, j - 1);//向左
    }
}
