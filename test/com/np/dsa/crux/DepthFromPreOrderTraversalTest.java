package com.np.dsa.crux;

import org.junit.Assert;
import org.junit.Test;

public class DepthFromPreOrderTraversalTest {
	
	
	DepthFromPreOrderTraversal obj = new DepthFromPreOrderTraversal();
	
	@Test
	public void test1(){
		String str = "nll";
		int output = obj.findDepth(str, str.length());
		Assert.assertEquals(2, output);
	}

}
