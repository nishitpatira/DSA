package com.nishit.hackerrank.hourrank29;

import java.util.LinkedList;
import java.util.List;

public class CustomizedChessBoard {

	public static void main(String[] args) {
		List<List<Integer>> board = new LinkedList<>();
		List<Integer> row1 = new LinkedList<>();
		List<Integer> row2 = new LinkedList<>();
		List<Integer> row3 = new LinkedList<>();
		board.add(row1);
		board.add(row2);
		board.add(row3);
		row1.add(0);
		row1.add(1);
		row1.add(0);
		row2.add(1);
		row2.add(0);
		row2.add(1);
		row3.add(1);
		row3.add(1);
		row3.add(0);
		System.out.println(solve(board));
	}

	public static String solve(List<List<Integer>> board) {
		int start = board.get(0).get(0);
		for (int k = 0; k < board.size()-1; k++) {
			for (int i = 0; i < board.get(k).size() - 1; i++) {
				if (board.get(k).get(i) != board.get(k).get(i + 1)) {
					continue;
				} else {
					return "No";
				}
			}
			if(board.get(k).get(0) != board.get(k+1).get(0)){
				continue;
			} else {
				return "No";
			}
		}
		return "Yes";
	}
}
