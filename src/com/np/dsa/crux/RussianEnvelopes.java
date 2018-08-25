package com.np.dsa.crux;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RussianEnvelopes {

	static class Envelope implements Comparable<Envelope> {
		int width;
		int height;

		public Envelope(int width, int height) {
			this.width = width;
			this.height = height;
		}

		@Override
		public int compareTo(Envelope o) {
			if (this.width > o.width) {
				return 1;
			} else if (this.width == o.width) {
				if (this.height > o.height) {
					return 1;
				} else if (this.height == o.height) {
					return 0;
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		}
		
		@Override
		public boolean equals(Object obj){
			if(obj instanceof Envelope){
				Envelope env = (Envelope) obj; 
				if(env.width == this.width){
					return false;
				} else {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return super.hashCode();
		}
	}

	public int maxEnvelopes(int[][] intEnvelopes) {
		double[][] envelopes = new double[intEnvelopes.length][intEnvelopes[0].length];
		List<Envelope> list = new LinkedList<>();
		for (int[] row : intEnvelopes) {
			list.add(new Envelope(row[0], row[1]));
		}
		Collections.sort(list);
		for(int i = 0; i< list.size(); i++){
			
		}
		
		for (int i = 0; i < list.size(); i++) {
			envelopes[i][0] = list.get(i).width;
			envelopes[i][1] = list.get(i).height;
		}
		for(int i = 0 ; i < list.size() - 1 ; i++){
			if(envelopes[i][0] == envelopes[i+1][0]){
				envelopes[i+1][1] = envelopes[i][1];
			}
		}

		// Now we are sorted on the basis of width. We now need to find longest
		// increasing subsequence on height.
		int[] matrix = new int[list.size()];
		int global_max = 0;
		for (int i = 0; i < list.size(); i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (envelopes[i][1] > envelopes[j][1]) {
					if (matrix[j] > max) {
						max = matrix[j];
					}
				}
			}
			matrix[i] = 1 + max;
			global_max = (global_max >= matrix[i]) ? global_max : matrix[i];
		}
		return global_max;
	}

	public static void main(String[] args) {
		
		int[][] envelopes = { { 5,4 }, {6,4 }, { 6, 7 }, { 2, 3 }};
		RussianEnvelopes rs = new RussianEnvelopes();
		System.out.println(rs.maxEnvelopes(envelopes));
	}
}
