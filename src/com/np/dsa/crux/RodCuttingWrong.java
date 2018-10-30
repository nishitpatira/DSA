/*
 * @author nishit patira
 */

//

//This is WRONG. Finding average price per length won't work

package com.np.dsa.crux;

import java.util.Arrays;

public class RodCuttingWrong {

	public static void main(String args[]) {
		//int arr[] = new int[] { 3, 5, 8, 9, 10, 17, 17, 20 };
		int arr[] = {1,5,8,9,10,17,17,20};
		int size = arr.length;
		System.out.println("Maximum Obtainable Value is " + cutRod(arr, size));
	}

	static int cutRod(int price[], int n) {
		int sum = 0;
		ArrayBean[] array = new ArrayBean[n];
		for (int i = 0; i < n; i++) {
			ArrayBean bean = new ArrayBean();
			bean.index = i + 1;
			bean.unitValue = (double) price[i] / (double) (i + 1);
			array[i] = bean;
		}

		Arrays.sort(array);
		for (int j = 0; j < array.length; j++) {
			int index = array[j].index;
			while (n > 0) {
				if (n - index >= 0) {
					n = n - index;
					sum = sum + price[index - 1];
				} else {
					break;
				}

			}
		}
		return sum;
	}
}

class ArrayBean implements Comparable<ArrayBean> {

	double unitValue;
	int index;

	@Override
	public int compareTo(ArrayBean o) {
		if (o.unitValue - this.unitValue > 0) {
			return 1;
		} else if (o.unitValue - this.unitValue == 0) {
			return 0;
		} else
			return -1;
	}

}