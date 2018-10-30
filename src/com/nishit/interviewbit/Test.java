package com.nishit.interviewbit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Test implements Runnable {

	private static AtomicInteger x = new AtomicInteger(0);

	static {
		System.out.println("How");
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		int min_length = Integer.MAX_VALUE;
		for (final String str : strs) {
			if (str.length() < min_length) {
				min_length = str.length();
			}
		}
		final StringBuilder builder = new StringBuilder();
		final Set<Character> setAtGivenIndex = new HashSet<Character>();
		for (int i = 0; i < min_length; i++) {
			for (final String str : strs) {
				setAtGivenIndex.add(str.charAt(i));
			}
			if (setAtGivenIndex.size() == 1) {
				for (final Character c : setAtGivenIndex) {
					builder.append(c);
				}
				setAtGivenIndex.clear();
			} else {
				break;
			}
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		System.out.println("Hi");
		/*
		 * Test test = new Test(); int[] coins = { 1, 3, 2, 4 };
		 * Arrays.sort(coins); int[] newArr = new int[coins.length];
		 * 
		 * for (int i = 0; i < coins.length; i++) { newArr[i] =
		 * coins[coins.length - 1 - i]; }
		 * 
		 * for (int i = 0; i < newArr.length; i++) {
		 * System.out.println(newArr[i]); }
		 */
		/*
		 * int count = 0; for(int i = 0 ; i < 100 ; i++){ for(i = 0 ; i < 100 ;
		 * i++){ count++; } } System.out.println(count);
		 */
		/*
		 * Thread t1 = new Thread(test); Thread t2 = new Thread(test); Thread t3
		 * = new Thread(test); Thread t4 = new Thread(test); Thread t5 = new
		 * Thread(test); System.out.println("Before anything in Main :  " + x);
		 * t1.start(); System.out.println("After starting T1 in Main : " + x);
		 * t2.start(); System.out.println("After starting T2 in Main : " + x);
		 * t3.start(); System.out.println("After starting T3 in Main : " + x);
		 * t4.start(); System.out.println("After starting T4 in Main : " + x);
		 * t5.start(); System.out.println("After starting T5 in Main : " + x);
		 */
		//final String[] strs = { "" };
		//System.out.println(longestCommonPrefix(strs));
		double total = 0;
		total += 5.6;
		total += 5.8;
		System.out.println(total);
		boolean isGreater = (total == 11.4);
		System.out.println(isGreater);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000000; i++) {
			x.incrementAndGet();
		}
		System.out.println("From Thread " + Thread.currentThread().getId() + " Value of X is : " + x);
	}

    public int findLongestChain(int[][] pairs) {
        
		Arrays.sort(pairs, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] > b[0]) {
					return 1;
				} else if (a[0] == b[0]) {
					if (a[1] > b[1]) {
						return 1;
					} else if (a[1] == b[1]) {
						return 0;
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			}
		});
       return lengthOfLIS(int[][] pairs);
	}

    
    public int lengthOfLIS(int[][] pairs) {
        int global_max = 1;
        int i = pairs.length-1;
        int j = i-1;
        while(j >= 0){
            if(pairs[i][0] > pairs[j][1]){
                global_max++;
                i = j;
            }
            j--;
        }
        return global_max;
	}

}
