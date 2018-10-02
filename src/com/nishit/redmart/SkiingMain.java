package com.nishit.redmart;

//http://geeks.redmart.com/2015/01/07/skiing-in-singapore-a-coding-diversion/
import java.util.LinkedList;
import java.util.List;

//TODO : Try this approach ::::: https://www.careercup.com/question?id=19369681

public class SkiingMain {

	private static int largestNodeCount = -1;
	
	private static int maxDepth = -1;

	public static void main(String[] args) {
		//int[][] map = { { 4, 10, 7, 3 }, { 2, 5, 9, 3 }, { 6, 3, 2, 5 }, { 4, 4, 1, 6 } };
		
		int[][] map = { {7, 2, 3, 4, 5}, {36, 37, 38, 34, 6}, {33, 44, 46, 40, 7}, {24, 43, 42, 41, 8}, {35, 32, 47, 30, 9} };
		 
		longestSki(map);
	}

	private static void longestSki(int[][] map) {
		int[][] longestSkiAux = new int[map.length][map[0].length];
		initializeAux(longestSkiAux);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				longestSkiUtil(map, longestSkiAux, i, j);
			}
		}
		List<Pair> possiblePaths = findMaxLongest(longestSkiAux);
		findMaxDepth(map, longestSkiAux,possiblePaths, largestNodeCount);
		System.out.println("Maximum Node count is : " + (largestNodeCount+1));
		System.out.println("Maximum Depth is      : " + maxDepth);
	}

	private static int longestSkiUtil(int[][] map, int[][] aux, int i, int j) {
		if (aux[i][j] != -1) {
			return aux[i][j];
		}
		// Move only in 2 directions
		if (isCorner(i, j, map.length, map[0].length)) {
			if (i == 0) {
				if (j == 0) {
					// Top Left Corner
					int countEast = map[i][j] > map[i][j + 1] ? longestSkiUtil(map, aux, i, j + 1) : -1;
					int countSouth = map[i][j] > map[i + 1][j] ? longestSkiUtil(map, aux, i + 1, j) : -1;
					aux[i][j] = 1 + Math.max(countEast, countSouth);
					return aux[i][j];

				} else {
					// Top Right Corner
					int countSouth = map[i][j] > map[i + 1][j] ? longestSkiUtil(map, aux, i + 1, j) : -1;
					int countWest = map[i][j] > map[i][j - 1] ? longestSkiUtil(map, aux, i, j - 1) : -1;
					aux[i][j] = 1 + Math.max(countWest, countSouth);
					return aux[i][j];
				}
			} else {
				if (j == 0) {
					// Bottom Left Corner
					int countNorth = map[i][j] > map[i - 1][j] ? longestSkiUtil(map, aux, i - 1, j) : -1;
					int countEast = map[i][j] > map[i][j + 1] ? longestSkiUtil(map, aux, i, j + 1) : -1;
					aux[i][j] = 1 + Math.max(countEast, countNorth);
					return aux[i][j];
				} else {
					// Bottom Right Corner
					int countNorth = map[i][j] > map[i - 1][j] ? longestSkiUtil(map, aux, i - 1, j) : -1;
					int countWest = map[i][j] > map[i][j - 1] ? longestSkiUtil(map, aux, i, j - 1) : -1;
					aux[i][j] = 1 + Math.max(countWest, countNorth);
					return aux[i][j];
				}
			}
		}

		// Move only in 3 directions
		if (isEdge(i, j, map.length, map[0].length)) {
			if (i == 0) {
				int countWest = map[i][j] > map[i][j - 1] ? longestSkiUtil(map, aux, i, j - 1) : -1;
				int countEast = map[i][j] > map[i][j + 1] ? longestSkiUtil(map, aux, i, j + 1) : -1;
				int countSouth = map[i][j] > map[i + 1][j] ? longestSkiUtil(map, aux, i + 1, j) : -1;
				aux[i][j] = 1 + Math.max(countWest, Math.max(countEast, countSouth));
				return aux[i][j];
			} else if (i == map.length - 1) {
				int countWest = map[i][j] > map[i][j - 1] ? longestSkiUtil(map, aux, i, j - 1) : -1;
				int countEast = map[i][j] > map[i][j + 1] ? longestSkiUtil(map, aux, i, j + 1) : -1;
				int countNorth = map[i][j] > map[i - 1][j] ? longestSkiUtil(map, aux, i - 1, j) : -1;
				aux[i][j] = 1 + Math.max(countWest, Math.max(countEast, countNorth));
				return aux[i][j];
			} else if (j == 0) {
				int countEast = map[i][j] > map[i][j + 1] ? longestSkiUtil(map, aux, i, j + 1) : -1;
				int countSouth = map[i][j] > map[i + 1][j] ? longestSkiUtil(map, aux, i + 1, j) : -1;
				int countNorth = map[i][j] > map[i - 1][j] ? longestSkiUtil(map, aux, i - 1, j) : -1;
				aux[i][j] = 1 + Math.max(countSouth, Math.max(countEast, countNorth));
				return aux[i][j];
			} else {
				int countWest = map[i][j] > map[i][j - 1] ? longestSkiUtil(map, aux, i, j - 1) : -1;
				int countSouth = map[i][j] > map[i + 1][j] ? longestSkiUtil(map, aux, i + 1, j) : -1;
				int countNorth = map[i][j] > map[i - 1][j] ? longestSkiUtil(map, aux, i - 1, j) : -1;
				aux[i][j] = 1 + Math.max(countWest, Math.max(countSouth, countNorth));
				return aux[i][j];
			}
		}

		// Move in all 4 directions
		int countEast = map[i][j] > map[i][j + 1] ? longestSkiUtil(map, aux, i, j + 1) : -1;
		int countWest = map[i][j] > map[i][j - 1] ? longestSkiUtil(map, aux, i, j - 1) : -1;
		int countSouth = map[i][j] > map[i + 1][j] ? longestSkiUtil(map, aux, i + 1, j) : -1;
		int countNorth = map[i][j] > map[i - 1][j] ? longestSkiUtil(map, aux, i - 1, j) : -1;
		aux[i][j] = 1 + Math.max(Math.max(countEast, countWest), Math.max(countSouth, countNorth));
		return aux[i][j];

	}

	private static void initializeAux(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = -1;
			}
		}
	}

	private static boolean isCorner(int i, int j, int rows, int columns) {
		if (i == 0 || i == rows - 1) {
			if (j == 0 || j == columns - 1) {
				return true;
			}
		}
		return false;
	}

	private static boolean isEdge(int i, int j, int rows, int columns) {
		if ((((i == 0 || i == rows - 1) && (j > 0 && j <= columns - 1))
				|| (((j == 0 || j == columns - 1) && (i > 0 && i <= rows - 1))))) {
			return true;
		}
		return false;
	}

	private static List<Pair> findMaxLongest(int[][] matrix) {
		Pair pair = new Pair();
		List<Pair> list = new LinkedList<>();
		list.add(pair);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] > largestNodeCount) {
					list.clear();
					largestNodeCount = matrix[i][j];
					pair.setI(i);
					pair.setJ(j);
					list.add(pair);
				} else if (matrix[i][j] == largestNodeCount) {
					Pair duplicate = new Pair(i, j);
					list.add(duplicate);
				}
			}
		}
		return list;
	}

	private static void findMaxDepth(int[][] map, int[][] longestSkiAux, List<Pair> possiblePaths, int maxCount) {
		for(Pair pair : possiblePaths){
			findMaxDepthUtil(map, longestSkiAux, pair.i, pair.j, maxCount, map[pair.i][pair.j]);
			System.out.println(maxDepth);
		}
	}
	
	private static void findMaxDepthUtil(int[][] map, int[][] longestSkiAux, int i, int j, int maxCount, int currMax){
		if(i < 0 || j < 0 || i >= map.length || j >= map[0].length){
			return;
		}
		
		if(maxCount == 0){
			if(currMax - map[i][j] > maxDepth){
				maxDepth = currMax - map[i][j];
				return;
			} else{
				return;
			}
		}
		
		// Move only in 2 directions
		if (isCorner(i, j, map.length, map[0].length)) {
			if (i == 0) {
				if (j == 0) {
					// Top Left Corner can move only east or south
					if(longestSkiAux[i][j+1] == maxCount -1){
						findMaxDepthUtil(map, longestSkiAux, i, j+1, maxCount-1,currMax);
						return;
					}
					if(longestSkiAux[i+1][j] == maxCount -1){
						findMaxDepthUtil(map, longestSkiAux, i+1, j, maxCount-1,currMax);
						return;
					}
				} else {
					// Top Right Corner can move only west or south
					if(longestSkiAux[i][j-1] == maxCount -1){
						findMaxDepthUtil(map, longestSkiAux, i, j-1, maxCount-1,currMax);
						return;
					}
					if(longestSkiAux[i+1][j] == maxCount -1){
						findMaxDepthUtil(map, longestSkiAux, i+1, j, maxCount-1,currMax);
						return;
					}				
				}
			} else {
				if (j == 0) {
					// Bottom Left Corner can move only east or north
					if(longestSkiAux[i][j+1] == maxCount -1){
						findMaxDepthUtil(map, longestSkiAux, i, j+1, maxCount-1,currMax);
						return;
					}
					if(longestSkiAux[i-1][j] == maxCount -1){
						findMaxDepthUtil(map, longestSkiAux, i-1, j, maxCount-1,currMax);
						return;
					}
				} else {
					// Bottom Right Corner can move only west or north
					if(longestSkiAux[i][j-1] == maxCount -1){
						findMaxDepthUtil(map, longestSkiAux, i, j-1, maxCount-1,currMax);
						return;
					}
					if(longestSkiAux[i-1][j] == maxCount -1){
						findMaxDepthUtil(map, longestSkiAux, i-1, j, maxCount-1,currMax);
						return;
					}
				}
			}
		}

		// Move only in 3 directions
		if (isEdge(i, j, map.length, map[0].length)) {
			if (i == 0) {
				//Can move east, west, south
				if(longestSkiAux[i][j+1] == maxCount -1){
					findMaxDepthUtil(map, longestSkiAux, i, j+1, maxCount-1,currMax);
					return;
				}
				if(longestSkiAux[i][j-1] == maxCount -1){
					findMaxDepthUtil(map, longestSkiAux, i, j-1, maxCount-1,currMax);
					return;
				}
				if(longestSkiAux[i+1][j] == maxCount -1){
					findMaxDepthUtil(map, longestSkiAux, i+1, j, maxCount-1,currMax);
					return;
				}
			} else if (i == map.length - 1) {
				//Can move east, west, north
				if(longestSkiAux[i][j+1] == maxCount -1){
					findMaxDepthUtil(map, longestSkiAux, i, j+1, maxCount-1,currMax);
					return;
				}
				if(longestSkiAux[i][j-1] == maxCount -1){
					findMaxDepthUtil(map, longestSkiAux, i, j-1, maxCount-1,currMax);
					return;
				}
				if(longestSkiAux[i-1][j] == maxCount -1){
					findMaxDepthUtil(map, longestSkiAux, i-1, j, maxCount-1,currMax);
					return;
				}
			} else if (j == 0) {
				//Can move east, north, south
				if(longestSkiAux[i][j+1] == maxCount -1){
					findMaxDepthUtil(map, longestSkiAux, i, j+1, maxCount-1,currMax);
					return;
				}
				if(longestSkiAux[i-1][j] == maxCount -1){
					findMaxDepthUtil(map, longestSkiAux, i-1, j, maxCount-1,currMax);
					return;
				}
				if(longestSkiAux[i+1][j] == maxCount -1){
					findMaxDepthUtil(map, longestSkiAux, i+1, j, maxCount-1,currMax);
					return;
				}
			} else {
				//Can move west, north, south
				if(longestSkiAux[i][j-1] == maxCount -1){
					findMaxDepthUtil(map, longestSkiAux, i, j-1, maxCount-1,currMax);
					return;
				}
				if(longestSkiAux[i-1][j] == maxCount -1){
					findMaxDepthUtil(map, longestSkiAux, i-1, j, maxCount-1,currMax);
					return;
				}
				if(longestSkiAux[i+1][j] == maxCount -1){
					findMaxDepthUtil(map, longestSkiAux, i+1, j, maxCount-1,currMax);
					return;
				}
			}
		}

		// Move in all 4 directions
		if(longestSkiAux[i][j-1] == maxCount -1){
			findMaxDepthUtil(map, longestSkiAux, i, j-1, maxCount-1,currMax);
			return;
		}
		if(longestSkiAux[i][j+1] == maxCount -1){
			findMaxDepthUtil(map, longestSkiAux, i, j+1, maxCount-1,currMax);
			return;
		}
		if(longestSkiAux[i-1][j] == maxCount -1){
			findMaxDepthUtil(map, longestSkiAux, i-1, j, maxCount-1,currMax);
			return;
		}
		if(longestSkiAux[i+1][j] == maxCount -1){
			findMaxDepthUtil(map, longestSkiAux, i+1, j, maxCount-1,currMax);
			return;
		}
		
	}

	static class Pair {
		int i;
		int j;

		public Pair() {

		}

		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public int getJ() {
			return j;
		}

		public void setJ(int j) {
			this.j = j;
		}

	}
}
