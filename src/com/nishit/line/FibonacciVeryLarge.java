package com.nishit.line;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FibonacciVeryLarge {
	
	public static void main(String[] args) {
		System.out.println(findFunctionValue(8181));
	}
	
	public static final String findFunctionValue(final int n){
		if(n == 0) return BigInteger.ZERO.toString();
		if(n == 1) return BigInteger.ONE.toString();
		BigDecimal beforePrev = BigDecimal.ZERO;
		BigDecimal prev = BigDecimal.ONE;
		BigDecimal currVal = null;
		for(int i = 2; i <= n ; i++){
			currVal = prev.add(beforePrev);
			beforePrev = prev;
			prev = currVal;
		}
		
		return currVal.toString();
	}

}
