package com.toOffer01;

public class code12 {
    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
//        char[][] board={{'A'}};
//        String word = "A";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean result = help(board, row, col, word);
                if (result) return true;
            }
        }
        return false;
    }

    public static boolean help(char[][] board, int row, int col, String word) {
        boolean result = false;
        if (board[row][col] != word.charAt(0)) {
            return false;
        } else if (word.length() > 1) {
            char temp=board[row][col];
            board[row][col]='/';
            if (row != 0) {
                result = help(board, row - 1, col, word.substring(1));
            }
            if (row != board.length - 1 && !result) {
                result = help(board, row + 1, col, word.substring(1));
            }
            if (col != 0 && !result) {
                result = help(board, row, col - 1, word.substring(1));
            }
            if (col != board[0].length - 1 && !result) {
                result = help(board, row, col + 1, word.substring(1));
            }
            board[row][col]=temp;
        } else result = true;
        return result;
    }
}
