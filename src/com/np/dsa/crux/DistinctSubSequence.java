package com.np.dsa.crux;

import java.util.LinkedList;
import java.util.List;

public class DistinctSubSequence {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2 };
		distinctSubSequence(arr, -1, new LinkedList<Integer>(), true);
	}

	private static void distinctSubSequence(int[] arr, int i, List<Integer> list, boolean toBeAdded) {
		if (i == arr.length) {
			return;
		}
		if (i == -1) {
			list.add(null);
		} else if (toBeAdded) {
			list.add(arr[i]);
		}
		if (i == arr.length - 1) {
			printList(list);
			return;
		}

		distinctSubSequence(arr, i + 1, list, true);
		list.remove(list.size() - 1);
		distinctSubSequence(arr, i + 1, list, false);

	}

	private static void printList(final List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) != null) {
				System.out.print(list.get(i) + " -> ");
			}
		}
		System.out.println(list.get(list.size() - 1));
	}
}
