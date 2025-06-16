package leetcode75.hashMapSet.sudoku;

import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                System.out.println(board[i][j] + "/" + board[j][i]);

                if (board[i][j] != '.' && (!row.add(board[i][j]))) {
                    return false;
                }
                if (board[j][i] != '.' && (!column.add(board[j][i]))) {
                    return false;
                }
            }
        }
        for (int a = 0; a < 9; a += 3) {
            for (int b = 0; b < 9; b += 3) {
                HashSet<Character> column = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i + a][j + b] != '.' && (!column.add(board[i + a][j + b]))) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}