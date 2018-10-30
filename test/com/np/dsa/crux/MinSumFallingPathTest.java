package com.np.dsa.crux;

import org.junit.Test;

public class MinSumFallingPathTest {
	
	MinSumFallingPath obj = new MinSumFallingPath();
	
	@Test
	public void test1(){
		final int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}};
		obj.findFallingPath(matrix);
	}

}
