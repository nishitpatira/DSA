package com.nishit.hackerrank.booking;

public class Solution1 {

	public static void main(String[] args) {
		int a = 3;
		int b = 3;
		int c = 3;
		System.out.println(triangle(a, b, c));
		
		
	}
	
	static int triangle(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0){
			return 0;
		}
		int aplusb = a+b;
		int bplusc = b+c;
		int cplusa = c+a;
		if(aplusb > c && bplusc > a && cplusa > b){
			if(aplusb == bplusc && bplusc == cplusa){
				return 1;
			} else {
				return 2;
			}
		}
		return 0;
    }
}
