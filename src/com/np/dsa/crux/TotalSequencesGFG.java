package com.np.dsa.crux;

//https://www.geeksforgeeks.org/sequences-given-length-every-element-equal-twice-previous/
public class TotalSequencesGFG {

	
	static int getTotalNumberOfSequences(int m, int n, int[][] aux) {

		if(n == 0){
			return 1;
		}
		if(n<0){
			return 0;
		}
		if(m<0){
			return 0;
		}
		if(m< (1 << n-1)){
			return 0;
		}
		if(aux[m][n] != 0){
			return aux[m][n];
		}
		aux[m][n] = getTotalNumberOfSequences(m - 1, n, aux) + getTotalNumberOfSequences(m / 2, n - 1, aux); 
		return aux[m][n];
	}

	public static void main(String[] args) {
		int m = 1000;
		int n = 20;
		int[][] aux = new int[m+1][n+1];
		long startTime = System.currentTimeMillis();
		int count = getTotalNumberOfSequences(m, n, aux);
		long endTime = System.currentTimeMillis();
		System.out.println("Total number of possible sequences : " + count);
		System.out.println("Total time taken for m=" + m + " n=" + n + "is : " + (endTime - startTime));
	}
}
