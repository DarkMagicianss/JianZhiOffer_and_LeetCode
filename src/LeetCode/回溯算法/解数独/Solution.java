package LeetCode.回溯算法.解数独;

import java.util.Arrays;

public class Solution {
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] boxs = new boolean[9][9];
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int temp_num = board[i][j] - '1';//将1-9转成0-8
                    rows[i][temp_num] = true;//行
                    cols[j][temp_num] = true;//列
                    int index = i / 3 + 3 * (j / 3);//box 9格
                    boxs[index][temp_num] = true;
                }
            }
        }
        sub_solveSudoku(board, 0);
    }
    //一个回溯法
    public boolean sub_solveSudoku(char[][] board, int index) {
        if (index >= 81) {
            //index达到最后的下标
            return true;
        }
        int i = index / 9;
        int j = index % 9;
        int box_index = i / 3 + 3 * (j / 3);
        if (board[i][j] == '.') {
            //寻找剩余的未填的数字
            for (int k = 0; k < 9; k++) {
                if (rows[i][k] == false && cols[j][k] == false && boxs[box_index][k] == false) {
                    rows[i][k] = true;
                    cols[j][k] = true;
                    boxs[box_index][k] = true;
                    board[i][j] = (char) ('1' + k);
                    if (sub_solveSudoku(board, index + 1)) break;
                    else {
                        rows[i][k] = false;
                        cols[j][k] = false;
                        boxs[box_index][k] = false;
                        board[i][j] = '.';
                    }
                }
            }
            //若9个数字都遍历完 目标位置board[i][j]还是'.'则返回false 否则就是已经成功找到目标
            if(board[i][j] == '.')return false;
            return true;//所有数字均遍历完 返回false
        } else {
            return sub_solveSudoku(board, index + 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] arr = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        s.solveSudoku(arr);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}

