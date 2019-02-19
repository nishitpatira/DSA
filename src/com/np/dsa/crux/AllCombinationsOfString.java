package com.np.dsa.crux;

/*Given a string, find all possible permutations and combinations of the same string
 * For ex: input = ABC, output = {ABC,ACB,BCA,BAC,CBA,CAB};
 */


public class AllCombinationsOfString {
	
	public void findAllCombinationsOfString(final String input){
		if(input == null || input.isEmpty()) return;
		findUtil(input, new String());
	}
	
	private void findUtil(final String input, final String output){
		if(input.length() == 0){
			System.out.println(output);
		}
		
		for(int i = 0; i < input.length(); i++){
			final String newInput = input.substring(0, i).concat(input.substring(i+1, input.length()));
			final String newOutput = output.concat(input.substring(i, i+1));
			findUtil(newInput, newOutput);
		}
	}

}
