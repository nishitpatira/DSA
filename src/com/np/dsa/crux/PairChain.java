package com.np.dsa.crux;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/maximum-length-of-pair-chain/description/
public class PairChain {

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
		public boolean equals(Object obj) {
			if (obj instanceof Envelope) {
				Envelope env = (Envelope) obj;
				if (env.width == this.width) {
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

	public int findLongestChain(int[][] pairs) {
		List<Envelope> list = new LinkedList<>();
		for (int[] row : pairs) {
			list.add(new Envelope(row[0], row[1]));
		}
		Collections.sort(list);
		return lengthOfLIS(list);
	}

	public int lengthOfLIS(List<Envelope> list) {
		int global_max = 0;
		int[] matrix = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (list.get(i).width > list.get(j).height) {
					if (matrix[j] > max) {
						max = matrix[j];
					}
				}
			}
			matrix[i] = 1 + max;
			global_max = matrix[i] > global_max ? matrix[i] : global_max;
		}
		return global_max;
	}

	public static void main(String[] args) {
		int[][] arr = { { -6, 9 }, { 1, 6 }, { 8, 10 }, { -1, 4 }, { -6, -2 }, { -9, 8 }, { -5, 3 }, { 0, 3 } };
		PairChain chain = new PairChain();
		System.out.println(chain.findLongestChain(arr));
	}

}
