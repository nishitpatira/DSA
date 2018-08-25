package com.nishit.leetcode.contest97;

public class EggBreak {

	public static void main(String[] args) {
		int eggs = 2;
		int floors = 4;
		System.out.println(superEggDrop(eggs, floors));
	}

	public static int superEggDrop(int eggs, int floors) {
		if (floors > 2) {
			return 1 + eggDropUtil(floors);
		} else {
			return eggDropUtil(floors);
		}

	}

	private static int eggDropUtil(int floors) {
		if (floors == 1) {
			return 1;
		}
		if(floors == 2){
			return 2;
		}
		return 1 + eggDropUtil(floors / 2);
	}
}
