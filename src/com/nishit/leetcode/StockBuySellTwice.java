package com.nishit.leetcode;

public class StockBuySellTwice {

	public int maxProfit(int[] array) {
		int[] maxIndexwise = new int[array.length];
		int min = array[0];
		int profit = -1;
		
		for(int i = 1 ; i < array.length ; i++){
			if(array[i] < min){
				min = array[i];
			} else {
				profit = Math.max(profit, array[i] - min);
			}
			maxIndexwise[i] = profit;
		}
		int max = array[array.length-1];
		profit = 0;
		for(int i = array.length - 2 ; i >= 0 ; i--){
			if(array[i] < max){
				profit = Math.max(profit, max - array[i]);
			} else {
				max = array[i];
			}
			maxIndexwise[i] += profit;
		}
		
		int returnMax = -1;
		for(int i = 0 ; i < maxIndexwise.length ; i++){
			if(maxIndexwise[i] > returnMax){
				returnMax = maxIndexwise[i];
			}
		}
		return returnMax;
	}
	
	public static void main(String[] args) {
		StockBuySellTwice stockBuy = new StockBuySellTwice();
		int[] array = {3,3,5,0,0,3,1,4};
		System.out.println(stockBuy.maxProfit(array));
	}

}
