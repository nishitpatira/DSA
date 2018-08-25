package com.np.dsa.crux;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStreamII {

	private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	private static PriorityQueue<Integer> maxHeap = null;
	static {
		maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());
	}

	private static double median = Integer.MIN_VALUE;

	public static void main(String[] args) {
		int[] array = { 2, 3 };
		for (int i = 0; i < array.length; i++) {
			calculateMedian(array[i]);
			System.out.println("Median is  : " + median);
		}
	}

	private static void calculateMedian(final int n) {
		if (minHeap.size() > maxHeap.size()) {
			if (n > median) {
				int temp = minHeap.poll();
				maxHeap.add(temp);
				minHeap.add(n);
			} else {
				maxHeap.add(n);
			}
			median = (double)(minHeap.peek() + maxHeap.peek()) / 2;
		} else if (minHeap.size() < maxHeap.size()) {
			if (n < median) {
				int temp = maxHeap.poll();
				minHeap.add(temp);
				maxHeap.add(n);
			} else {
				minHeap.add(n);
			}
			median = (double)(minHeap.peek() + maxHeap.peek()) / 2;
		} else {
			if (n > median) {
				minHeap.add(n);
				median = minHeap.peek();
			} else {
				maxHeap.add(n);
				median = maxHeap.peek();
			}
		}
	}
}
