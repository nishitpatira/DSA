package com.nishit.hackerrank.goldman;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SpecialElementsInMatrix {

	private static int rows = 0;
	private static int columns = 0;
	private static final Set<Integer> set = new HashSet<>();
	private static boolean isViolation = false;

	private static final int countSpecialElements(final List<List<Integer>> matrix) {
		if (matrix == null)
			return -1;

		rows = matrix.size();
		columns = matrix.get(0).size();

		rowWiseTraversal(matrix);
		if (isViolation)
			return -1;

		columnWiseTraversal(matrix);
		if (isViolation)
			return -1;
		return set.size();
	}

	private static final void rowWiseTraversal(final List<List<Integer>> matrix) {
		for (int i = 0; i < rows; i++) {
			Integer min = Integer.MAX_VALUE;
			Integer max = 0;
			for (int j = 0; j < columns; j++) {
				Integer elem = matrix.get(i).get(j);
				if (elem == min || elem == max) {
					isViolation = true;
				}
				if (elem > max) {
					max = elem;
				}
				if (elem < min) {
					min = elem;
				}

			}
			set.add(min);
			set.add(max);
		}
	}

	private static final void columnWiseTraversal(final List<List<Integer>> matrix) {
		for (int i = 0; i < columns; i++) {
			Integer min = Integer.MAX_VALUE;
			Integer max = 0;
			for (int j = 0; j < rows; j++) {
				Integer elem = matrix.get(j).get(i);
				if (elem == min || elem == max) {
					isViolation = true;
				}
				if (elem > max) {
					max = elem;
				}
				if (elem < min) {
					min = elem;
				}
			}
			set.add(min);
			set.add(max);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> argument = new LinkedList<>();
		List<Integer> row1 = new LinkedList<>();
		List<Integer> row2 = new LinkedList<>();
		List<Integer> row3 = new LinkedList<>();
		row1.add(1);
		row1.add(3);
		row1.add(4);
		row2.add(5);
		row2.add(2);
		row2.add(9);
		row3.add(8);
		row3.add(7);
		row3.add(6);
		argument.add(row1);
		argument.add(row2);
		argument.add(row3);
		System.out.println(countSpecialElements(argument));
	}
}
