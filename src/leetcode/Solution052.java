package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution052 {
    private int count = 0;
    public int totalNQueens(int n) {
        List<StringBuilder> board = new ArrayList<>();
        for(int i = 0;i < n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j < n;j++){
                sb.append('.');
            }
            board.add(sb);
        }
        totalNQueens(board, 0);
        return count;
    }
    private void totalNQueens(List<StringBuilder> board, int row){
        if(row == board.size()){
            count++;
            return;
        }
        int n = board.get(row).length();
        for(int col = 0;col < n;col++){
            if(!isValid(board, row, col)){
                continue;
            }
            board.get(row).setCharAt(col, 'Q');
            totalNQueens(board, row + 1);
            board.get(row).setCharAt(col, '.');
        }
    }
    //是否可以在board[row][col]放置
    private boolean isValid(List<StringBuilder> board, int row, int col){
        int size = board.size();
        //这一列有没有
        for(int i = 0;i < row;i++){
            if(board.get(i).charAt(col) == 'Q'){
                return false;
            }
        }
        int r = row - 1;
        int c = col - 1;
        //验证左上角有没有
        while(r >= 0 && c >= 0){
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
            c--;
        }
        r = row - 1;
        c = col + 1;
        //验证右上角有没有
        while(r >= 0 && c < size){
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}
