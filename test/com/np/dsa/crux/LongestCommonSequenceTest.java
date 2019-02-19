package com.np.dsa.crux;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSequenceTest {
	
	@Test
	public void test1(){
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		String output = LongestCommonSequence.findLCS(str1, str2);
		Assert.assertEquals("GTAB", output);
	}
}
