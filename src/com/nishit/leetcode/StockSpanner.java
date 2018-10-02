package com.nishit.leetcode;

import java.util.Stack;

public class StockSpanner {
	Stack<StockSpanObject> stack = null;

	public static class StockSpanObject {
		int value;
		int span;

		public StockSpanObject(int value, int span) {
			this.value = value;
			this.span = span;
		}
	}

	public StockSpanner() {
		stack = new Stack<StockSpanObject>();
	}

	public int next(int price) {
		StockSpanObject obj = new StockSpanObject(price, 1);
		if (stack.isEmpty()) {
		} else if (stack.peek().value > price) {
		} else {
			while (!stack.isEmpty() && stack.peek().value <= price) {
				obj.span += stack.pop().span;
			}
		}
		stack.push(obj);
		return obj.span;
	}
	
	public static void main(String[] args) {
		StockSpanner spanner = new StockSpanner();
		System.out.println(spanner.next(31));
		System.out.println(spanner.next(41));
		System.out.println(spanner.next(48));
		System.out.println(spanner.next(59));
		System.out.println(spanner.next(79));
	}

}
