package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode37 {
    //最后放真实数字，前面放位置。
    private boolean[][] row = new boolean[9][9];
    private boolean[][] col = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private List<int[]> spaces = new ArrayList<>();
    private boolean valid = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    row[i][board[i][j] - '1'] = true;
                    col[j][board[i][j] - '1'] = true;
                    int br = i / 3;
                    int bc = j / 3;
                    block[br][bc][board[i][j] - '1'] = true;
                } else {
                    spaces.add(new int[]{i, j});
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int x = spaces.get(pos)[0], y = spaces.get(pos)[1];
        for (int i = 0; i < 9; i++) {
            if(!row[x][i] && !col[y][i]&&!block[x / 3][y / 3][i] && !valid){
                board[x][y] = (char) (i + '1');
                row[x][i] = col[y][i] = block[x / 3][y / 3][i] = true;
                dfs(board, pos + 1);
                row[x][i] = col[y][i] = block[x / 3][y / 3][i] = false;
            }
        }
    }
}
