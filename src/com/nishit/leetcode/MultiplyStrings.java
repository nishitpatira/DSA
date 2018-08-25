package com.nishit.leetcode;

public class MultiplyStrings {
	
	public static void main(String[] args) {
		
		String str1 = "123";
		String str2 = "456";
		System.out.println(multiply(str1,str2));
	}
	
	private static String multiply(final String str1, final String str2){
		int carryOver = 0;
		int product = 0;
		int[] sums = new int[str2.length()];
		for(int j = str2.length() -1 ; j >= 0 ; j--){
			for(int i = str1.length() -1 ; i >= 0 ; i--){
				product = (str2.charAt(i) - 48) * (str1.charAt(j) - 48) + carryOver;
				sums[j] *= 10;
				if(i == 0){
					if(product > 9){
						int tens = product / 10;
						int ones = product % 10;
						sums[j] +=	ones;
						sums[j] *= 10;
						sums[j] += tens;
					} else{
						sums[j] += product; 
					}
				}
				if(product > 9){
					carryOver = product / 10;
					sums[j] += (product % 10);
				} else {
					carryOver = 0;
					sums[j] += product;
				}
			}
		}
		return null;
	}

}
