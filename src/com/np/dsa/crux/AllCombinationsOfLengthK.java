package com.np.dsa.crux;

/*
 * Find all combinations of length k.
 * For ex : Input : {A,B,C}, k = 2
 * Output : { {A,B},{B,A},{A,C},{C,A},{B,C},{C,B} }
 */
public class AllCombinationsOfLengthK {
	
	public void allCombinations(final String input, final int k){
		String output = new String();
		util(input, output, k);
	}
	
	
	private void util(String input, String output, int k){
		if(output.length() == k){
			System.out.println(output);
		}
		for(int i = 0; i < input.length(); i++){
			final String newInput = input.substring(0, i).concat(input.substring(i+1, input.length()));
			final String newOutput = output.concat(input.substring(i, i+1));
			util(newInput, newOutput, k);
		}
	}

}
