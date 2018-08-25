package com.np.dsa.crux;

//https://www.geeksforgeeks.org/sequences-given-length-every-element-equal-twice-previous/
public class TotalSequences {

	public static void main(String[] args) {
		int m = 15;
		int n = 4;
		long startTime = System.currentTimeMillis();
		int count = getSequences(m, n);
		long endTime = System.currentTimeMillis();
		System.out.println("Total number of possible sequences : " + count);
		System.out.println("Total time taken for m=" + m + " n=" + n + "is : " + (endTime - startTime));
	}

	private static int getSequences(int m, int n) {
		final int constant = (1 << (n - 1));
		if (m < constant) {
			return 0;
		}
		if (m == 0) {
			return 1;
		}
		int count = 0;
		for (int i = constant; i <= m; i++) {
			count += getSequences((i >> 1), n - 1);
		}
		return count;
	}
}
