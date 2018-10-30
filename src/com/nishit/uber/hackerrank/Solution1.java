package com.nishit.uber.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution1 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int length = Integer.parseInt(scanner.nextLine());
		int[] array = new int[length];
		for(int i = 0 ; i < length ; i++){
			array[i] = Integer.parseInt(scanner.nextLine());
		}
		int k = Integer.parseInt(scanner.nextLine());
		
		int count = countEvenSubArrays(array,k);
		
		System.out.println(count);
		scanner.close();
	}
	
	public static int countEvenSubArrays(final int array[], final int m){
        int count = 0;
        for(int i = 0; i <=m ; i++){
            count += countEvenSubArraysUtil(array, i);
        }
        return count;
    }

    public static int countEvenSubArraysUtil(final int array[], final int m) {
        int count = 0;
        int prefix[] = new int[array.length];
        int odd = 0;

        // traverse in the array
        for (int i = 0; i < array.length; i++) {
            prefix[odd]++;

            // if array element is odd
            if ((array[i] & 1) == 1)
                odd++;

            // when number of odd
            // elements >= M
            if (odd >= m)
                count += prefix[odd - m];
        }

        return count;
    }
}
