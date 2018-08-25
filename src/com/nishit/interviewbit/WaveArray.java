package com.nishit.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(6);
		list.add(17);
		list.add(15);
		list.add(13);
		// list.add(5);
		System.out.println(wave(list).toString());
		System.out.println(waveLexiSmallest(list).toString());
	}

	public static ArrayList<Integer> wave(ArrayList<Integer> list) {
		for (int i = 1; i < list.size(); i = i + 2) {
			if (list.get(i - 1) < list.get(i)) {
				int temp = list.get(i - 1);
				list.set(i - 1, list.get(i));
				list.set(i, temp);
			}
			if (i != list.size() - 1) {
				if (list.get(i) > list.get(i + 1)) {
					int temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);
				}
			}
		}
		return list;
	}

	public static ArrayList<Integer> waveLexiSmallest(ArrayList<Integer> list) {
		Collections.sort(list);
		for (int i = 0; i < list.size(); i = i + 2) {
			if (i != list.size() - 1) {
				int temp = list.get(i);
				list.set(i, list.get(i + 1));
				list.set(i + 1, temp);
			}
		}
		return list;
	}
}
