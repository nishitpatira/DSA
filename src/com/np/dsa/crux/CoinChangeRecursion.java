package com.np.dsa.crux;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class CoinChangeRecursion {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] coins = ScannerUtils.scanForIntArray(scanner);
		int value = ScannerUtils.scanForNumber(scanner);
		scanner.close();
		count(coins, coins.length, value);
	}
	
	private static int count(int[] coins, int noOfCoins, int input){
		if(input == 0){
			return 1;
		}
		if(input < 0){
			return 0;
		} 
		if(noOfCoins == 0){
			return 0;
		}
		return count(coins, noOfCoins - 1, input) + count(coins, noOfCoins, input - coins[noOfCoins - 1]);
	}
}
