package com.nishit.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		/*
		 * char[][] sudoku = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
		 * { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8',
		 * '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.',
		 * '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7',
		 * '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.',
		 * '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5'
		 * }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		 */
		/*
		 * char[][] sudoku = { {'.','.','4','.','.','.','6','3','.'},
		 * {'.','.','.','.','.','.','.','.','.'},
		 * {'5','.','.','.','.','.','.','9','.'},
		 * {'.','.','.','5','6','.','.','.','.'},
		 * {'4','.','3','.','.','.','.','.','1'},
		 * {'.','.','.','7','.','.','.','.','.'},
		 * {'.','.','.','5','.','.','.','.','.'},
		 * {'.','.','.','.','.','.','.','.','.'},
		 * {'.','.','.','.','.','.','.','.','.'}};
		 */

		char[][] sudoku = { { '.', '.', '.', '.', '.', '.', '5', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '9', '3', '.', '.', '2', '.', '4', '.', '.' }, { '.', '.', '7', '.', '.', '.', '3', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '3', '4', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '3', '.', '.', '.' }, { '.', '.', '.', '.', '.', '5', '2', '.', '.' } };
		System.out.println(isValidSudoku(sudoku));
	}

	private static boolean isValidSudoku(char[][] board) {
		return verifyRows(board) && verifyColumns(board) && verifyBoxes(board);
	}

	private static boolean verifyRows(char[][] board) {
		Set<Character> elementSet = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			char[] row = board[i];
			for (Character element : row) {
				if (element != '.') {
					if (elementSet.contains(element)) {
						return false;
					} else {
						elementSet.add(element);
					}
				}
			}
			elementSet.clear();
		}
		return true;
	}

	private static boolean verifyColumns(char[][] board) {
		Set<Character> elementSet = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char element = board[j][i];
				if (element != '.') {
					if (elementSet.contains(element)) {
						return false;
					} else {
						elementSet.add(element);
					}
				}
			}
			elementSet.clear();
		}
		return true;
	}

	private static boolean verifyBoxes(char[][] board) {
		Set<Character> elementSet = new HashSet<>();
		int startColumn = 0, startRow = 0, endRow = 2, endColumn = 2;
		while (endColumn < 9 && endRow < 9) {
			for (int i = startRow; i <= endRow; i++) {
				for (int j = startColumn; j <= endColumn; j++) {
					char element = board[i][j];
					if (element != '.') {
						if (elementSet.contains(element)) {
							return false;
						} else {
							elementSet.add(element);
						}
					}
				}
			}
			elementSet.clear();
			if(endColumn < 8){
				startColumn = endColumn + 1;
				endColumn = startColumn + 2;
			} else {
				startRow = endRow + 1;
				endRow = startRow + 2;
				startColumn = 0;
				endColumn = 2;
			}
			
		}
		return true;
	}
}
