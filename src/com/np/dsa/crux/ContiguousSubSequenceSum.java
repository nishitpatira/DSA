package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class ContiguousSubSequenceSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = ScannerUtils.scanForIntArray(scanner);
		int sum = ScannerUtils.scanForNumber(scanner);
		int local_sum = 0, starting_index = 0, ending_index = 0;
		for (int i = 0; i < array.length; i++) {
			local_sum = local_sum + array[i];
			ending_index = i;
			while (local_sum > sum) {
				local_sum = local_sum - array[starting_index];
				starting_index++;
			}
			if (local_sum == sum) {
				System.out.println("Starting index is : " + starting_index + " And ending index is : " + ending_index);
			}
		}
	}

}
