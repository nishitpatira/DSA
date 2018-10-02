package com.nishit.zalando.codility;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class CountNonDecreasingSubSequence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int[] array = ScannerUtils.scanForIntArray(scanner);
		System.out.println(new CountNonDecreasingSubSequence().solution(array));
	}

	public final int solution(final int[] array) {
		
		if(array == null){
			return 0;
		}
		
		int falseCount = 0;
		int falseIndexInAux = 0;
		final boolean[] auxArray = new boolean[array.length - 1];

		if (array.length < 2) {
			return array.length;
		}

		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] <= array[i + 1]) {
				auxArray[i] = true;
			} else {
				auxArray[i] = false;
				falseIndexInAux = i;
				falseCount++;
			}
		}
		
		if(falseCount == 0){
			return array.length;
		} else if(falseCount >= 2){
			return 0;
		} else {
			return findCountForOneWrong(array, falseIndexInAux);
		}
	}
	
	private final int findCountForOneWrong(final int[] array, final int indexOfInterest){
		int count = 0;
		if(indexOfInterest == 0){
			count++;
			if(array[0] <= array[2]){
				count++;
			}
			return count;
		} else if(indexOfInterest == array.length - 2){
			count++;
			if(array[array.length - 3] <= array[ array.length - 1]){
				count++;
			}
			return count;
		} else {
			if(array[indexOfInterest - 1] <= array[indexOfInterest + 1]){
				count++;
			}
			if(array[indexOfInterest] <= array[indexOfInterest + 2]){
				count++;
			}
			return count;
		}
	}
}
