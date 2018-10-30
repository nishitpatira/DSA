package com.np.dsa.crux;
//https://www.youtube.com/watch?v=jaNZ83Q3QGc

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class CoinChangeCount {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int amount = ScannerUtils.scanForNumber(scanner);
		int[] coins = ScannerUtils.scanForIntArray(scanner);
		System.out.println(changeCount(amount, coins));
		scanner.close();
	}

	public static int changeCount(final int amount, final int[] coins) {
		int[] aux = new int[amount + 1];
		aux[0] = 1;
		for (int coin : coins) {
			for (int i = 1; i < aux.length; i++) {
				if (i >= coin) {
					aux[i] = aux[i] + aux[i - coin];
					print(aux);
				}
			}
		}
		return aux[aux.length - 1];
	}
	
	public static void print(int[] arr){
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
