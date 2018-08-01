package com.nishit.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

public class GenerateParantheses {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = ScannerUtils.scanForNumber(scanner);
		scanner.close();
		List<String> strings = generateParenthesis(n);
		for(String str : strings){
			System.out.println(str);
		}
	}
	
	public static List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        generateParenthesisRecur(0,0,n, new String(""), list);
        return list;
    }
	
	private static void generateParenthesisRecur(int openCount, int closeCount, int n, String str, List<String> list){
		if(openCount == closeCount && openCount == n){
			list.add(str);
		}
		
		if(openCount < n)
		generateParenthesisRecur(openCount+1, closeCount, n, str.concat("("), list);
		if(closeCount < n && closeCount + 1 <= openCount)
		generateParenthesisRecur(openCount, closeCount+1, n, str.concat(")"), list);
		
	}
}
