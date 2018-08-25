package com.np.dsa.crux;

//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

public class Knapsack {
	private static int max_val = 0;

	// Returns the maximum value that can be put in a knapsack of capacity W
	static void knapSack(int[] val, int[] wt, int W, int index, int current_weight, int current_val)
	{
		if(current_weight <= W){
			if(current_val > max_val) {
				max_val = current_val;
			}
		}
		if(index >= val.length || current_weight > W) {
			return;
		}
		final int new_current_weigth = current_weight + wt[index];
		final int new_current_val = current_val + val[index];
		index++;
		knapSack(val,wt,W,index,new_current_weigth,new_current_val);
		knapSack(val,wt,W,index,current_weight,current_val);
		return;
	}


	// Driver program to test above function
	public static void main(String args[])
	{
		final int val[] = new int[]{6, 10, 12};
		final int wt[] = new int[]{1, 2, 3};
		final int W = 5;
		knapSack(val,wt,W,0,0,0);
		System.out.println(max_val);
	}
}
