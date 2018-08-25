package com.np.dsa.crux;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class CoinChangeMyWay {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int amount = ScannerUtils.scanForNumber(scanner);
		int[] coins = ScannerUtils.scanForIntArray(scanner);
		System.out.println(coinChange(coins, amount));
	}

	public static int coinChange(final int[] coins, final int amount) {
		if(amount < 0){
			return -1;
		}
		if(amount == 0){
			return 0;
		}
		
		if(coins.length == 0){
			return -1;
		}
		int[] aux = new int[amount + 1];
		int minCoin = Integer.MAX_VALUE;
		for (int coin : coins) {
			if(coin < minCoin){
				minCoin = coin;
			}
			if (coin <= amount) {
				aux[coin] = 1;
			}
		}
		
		if(minCoin > amount){
			return -1;
		}

		for(int i = minCoin+1 ; i < aux.length ; i++){
			if(i == 166){
				System.out.println();
			}
			if(i == 269){
				System.out.println();
			}
			if(i == 6248){
				System.out.println();
			}
			if( i== 6249){
				System.out.println();;
			}
			if(aux[i] == 0){
				List<Integer> previousAmounts = new LinkedList<>();
				for(int coin : coins){
					if(i - coin > 0){
						previousAmounts.add(aux[i-coin]);
					}
				}
				Collections.sort(previousAmounts);
				aux[i] = previousAmounts.get(0) == 0 ? 0 : 1 + previousAmounts.get(0);
			}
			
		}
		return aux[aux.length-1] == 0 ? -1 : aux[aux.length-1];
	}
}
