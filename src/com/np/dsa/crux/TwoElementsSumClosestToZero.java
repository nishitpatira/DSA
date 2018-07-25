package com.np.dsa.crux;

import java.util.Arrays;
import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;
import com.np.dsa.utils.Utils;

public class TwoElementsSumClosestToZero {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = ScannerUtils.scanForIntArray(scanner);
		Arrays.sort(array);
		Utils.printArray(array);
		int i = 0, j = array.length - 1;
		int local_sum;
		int closest_sum = Integer.MAX_VALUE;
		int index_1=0, index_2=0;
		while (i < j) {
			local_sum = array[i] + array[j];
			if(Math.abs(local_sum) < Math.abs(closest_sum)){
				closest_sum = local_sum;
				index_1 = i;
				index_2 = j;
			}
			if(local_sum > 0){
				j--;
			}
			else if (local_sum < 0) {
				i++;
			}
			else {
				System.out.println("Got exact 0 sum for : " + array[i] + " & " + array[j]);
			}
		}
		System.out.println("Closest elements are : " + array[index_1] + " & " + array[index_2]);
	}

}
