package com.nishit.spoj;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DistributeBallotBoxes {

	static class CityBox implements Comparable<CityBox> {
		int population;
		int providedBoxes;
		float average;

		public CityBox(int population, int providedBoxes) {
			this.population = population;
			this.providedBoxes = providedBoxes;
			this.average = population / providedBoxes;
		}

		@Override
		public int compareTo(CityBox other) {
			if (this.average < other.average) {
				return -1;
			} else if (this.average == other.average) {
				return 0;
			} else {
				return 1;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = "ABCD";
		while(true){
			str = scanner.nextLine();
			if(str.equals("-1 -1")){
				break;
			}
			String[] strArr = str.split(" ");
			if(strArr.length != 2){
				continue;
			}
			int cities = Integer.parseInt(strArr[0]);
			int ballots = Integer.parseInt(strArr[1]);
			int[] population = new int[cities];
			String input = scanner.nextLine();
			String[] inputArr = input.split(" ");
			for (int i = 0; i < cities; i++) {
				population[i] = Integer.parseInt(inputArr[i]);
			}

			System.out.println(findMinMaxAvg(population, ballots));
			
			
		}
		scanner.close();
	}

	public static int findMinMaxAvg(final int[] population, int ballots) {
		PriorityQueue<CityBox> maxHeap = new PriorityQueue<>(11, Collections.reverseOrder());
		for (int elem : population) {
			CityBox box = new CityBox(elem, 1);
			maxHeap.add(box);
			ballots--;
		}
		while (ballots != 0) {
			CityBox box = maxHeap.poll();
			box.average = box.population / (box.providedBoxes + 1);
			box.providedBoxes++;
			maxHeap.add(box);
			ballots--;
		}
		return (int) maxHeap.peek().average;

	}
}
