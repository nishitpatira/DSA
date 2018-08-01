package com.nishit.leetcode;

import java.util.Scanner;

import com.np.dsa.utils.ScannerUtils;

//https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = ScannerUtils.scanForIntArray(scanner);
		System.out.println(maxArea(array));
	}
	
	public static int maxArea(int[] height) {
        int globalMaxArea = 0;
        int startIndex = 0;
        int endIndex = height.length - 1;
        while(startIndex < endIndex){
        	int min = findMinVal(height, startIndex, endIndex);
        	int localMaxArea = min* (endIndex - startIndex);
        	if(localMaxArea > globalMaxArea){
        		globalMaxArea = localMaxArea;
        	}
        	if(isStartSmall(height, startIndex, endIndex)){
        		startIndex++;
        	} else {
        		endIndex--;
        	}
        }
		
		return globalMaxArea;
    }
	
	private static int findMinVal(int[] height, int startIndex, int endIndex){
		return Math.min(height[startIndex], height[endIndex]);
	}
	
	private static boolean isStartSmall(int[] height, int startIndex, int endIndex){
		return height[startIndex] < height[endIndex] ? Boolean.TRUE : Boolean.FALSE;
	}
}
