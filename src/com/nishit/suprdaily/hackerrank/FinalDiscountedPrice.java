package com.nishit.suprdaily.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FinalDiscountedPrice {

	public static void main(String[] args) {
		int[] arr = { 6,5,4,3,2,1 };
		List<Integer> inputList = new ArrayList<>();
		for (int i : arr) {
			inputList.add(i);
		}
		finalPrice(inputList);
	}
	
	private static int initializeForLastElement(Stack<Integer> lowPricesStack, Stack<Integer> unchangedIndex, List<Integer> prices){
		lowPricesStack.push(prices.get(prices.size() - 1));
		unchangedIndex.push(prices.size() - 1);
		return prices.get(prices.size()-1);
	}

	public static void finalPrice(List<Integer> prices) {
		if (prices == null) {
			return;
		}
		Stack<Integer> lowPricesStack = new Stack<>();
		Stack<Integer> unchangedIndex = new Stack<>();
		int sum = initializeForLastElement(lowPricesStack, unchangedIndex, prices);
		for (int i = prices.size() - 2; i >= 0; i--) {
			int val = prices.get(i);
			sum += val;
			if (val >= lowPricesStack.peek()) {
				sum -= lowPricesStack.peek();
				lowPricesStack.push(val);
			} else {
				lowPricesStack.pop();
				while (!lowPricesStack.isEmpty()) {
					if (val >= lowPricesStack.peek()) {
						sum -= lowPricesStack.peek();
						lowPricesStack.push(val);
						break;
					} else {
						lowPricesStack.pop();
					}
				}
				if (lowPricesStack.isEmpty()) {
					lowPricesStack.push(val);
					unchangedIndex.push(i);
				}
			}
		}
		System.out.println(sum);
		while(!unchangedIndex.isEmpty()){
			System.out.print(unchangedIndex.pop() + " ");
		}
	}

}
