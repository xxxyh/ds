package leetcode;

public class Solution529 {

    public char[][] updateBoard(char[][] board, int[] click) {
        if(board == null || click == null || click.length != 2){
            return board;
        }
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int i,int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'E'){
            return;
        }
        int count = countMine(board, i, j);
        if(count == 0){
            board[i][j] = 'B';
            dfs(board, i - 1, j - 1);
            dfs(board, i - 1, j + 1);
            dfs(board, i - 1, j);
            dfs(board, i, j - 1);
            dfs(board, i ,j + 1);
            dfs(board, i +1, j - 1);
            dfs(board,i + 1, j);
            dfs(board, i + 1,j + 1);
        }else{
            board[i][j] = Character.forDigit(count, 10);
        }
    }

    private int countMine(char[][] board, int i, int j) {
        return isMine(board, i - 1, j - 1) +
                isMine(board, i - 1, j + 1) +
                isMine(board, i - 1, j) +
                isMine(board, i, j - 1) +
                isMine(board, i ,j + 1) +
                isMine(board, i +1, j - 1) +
                isMine(board,i + 1, j) +
                isMine(board, i + 1,j + 1);
    }
    private int isMine(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'M'){
            return 0;
        }
        return 1;//是地雷
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'B','1','E','1','B'},
                {'B','1','M','1','B'}
                ,{'B','1','1','1','B'},
                {'B','B','B','B','B'}};
        int[] click = new int[]{1, 2};
        char[][] result = new Solution529().updateBoard(board, click);
        for(char[] chars: result){
            for(char c : chars){
                System.out.print(c + "");
            }
            System.out.println();
        }
    }
}
