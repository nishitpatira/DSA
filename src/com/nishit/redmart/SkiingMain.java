package com.nishit.redmart;
//http://geeks.redmart.com/2015/01/07/skiing-in-singapore-a-coding-diversion/
import java.util.LinkedList;
import java.util.List;

//TODO : Try this approach ::::: https://www.careercup.com/question?id=19369681

public class SkiingMain {

	public static void main(String[] args) {
		int[][] map = {{4,8,7,3},{2,5,9,3},{6,3,2,5},{4,4,1,6}};
		/*int[][] map = { {7,  2,  3,  4,  5},
						{36, 37, 38, 34, 6},
						{33, 44, 46, 40, 7},
						{24, 43, 42, 41, 8},
						{35, 32, 47, 30, 9} };*/
		longestSki(map);
	}
	
	private static void longestSki(int[][] map){
		int[][] longestSkiAux = new int[map.length][map[0].length];
		initializeAux(longestSkiAux);
		for(int i = 0 ; i < map.length ; i++){
			for(int j = 0 ; j < map[0].length ; j++){
				longestSkiUtil(map, longestSkiAux, i, j);
			}
		}
		List<Pair> possiblePaths = findMaxLongest(longestSkiAux);
		int longest = -1;
		for(Pair pair : possiblePaths){
			if(pair.getJ() == -1){
				longest = pair.getI();
			}
		}
		System.out.println("Maximum Node count is : " + (longest));
		//findMaxDepth(map,possiblePaths, longest);
	}
	
	private static int longestSkiUtil(int[][] map, int[][] aux, int i, int j){
		if(aux[i][j] != -1){
			return aux[i][j];
		}
		//Move only in 2 directions
		if(isCorner(i,j, map.length, map[0].length)){
			if(i == 0){
				if( j == 0){
					//Top Left Corner
					int countEast = map[i][j] > map[i][j+1] ? longestSkiUtil(map, aux, i, j+1) : -1;
					int countSouth = map[i][j] > map[i+1][j] ? longestSkiUtil(map, aux, i+1, j) : -1;
					aux[i][j] = 1 + Math.max(countEast, countSouth);
					return aux[i][j];
					
				} else {
					//Top Right Corner
					int countSouth = map[i][j] > map[i+1][j] ? longestSkiUtil(map, aux, i+1, j) : -1;
					int countWest = map[i][j] > map[i][j-1] ? longestSkiUtil(map, aux, i, j-1)  : -1;
					aux[i][j] = 1 + Math.max(countWest, countSouth);
					return aux[i][j];
				}
			} else{ 
				if(j == 0){
					//Bottom Left Corner
					int countNorth = map[i][j] > map[i-1][j] ? longestSkiUtil(map, aux, i-1, j) : -1; 
					int countEast = map[i][j] > map[i][j+1] ? longestSkiUtil(map, aux, i, j+1) : -1;
					aux[i][j] = 1 + Math.max(countEast, countNorth);
					return aux[i][j];
				} else {
					//Bottom Right Corner
					int countNorth = map[i][j] > map[i-1][j] ? longestSkiUtil(map, aux, i-1, j) : -1;
					int countWest = map[i][j] > map[i][j-1] ? longestSkiUtil(map, aux, i, j-1) : -1;
					aux[i][j] = 1 + Math.max(countWest, countNorth);
					return aux[i][j];
				}
			}
		}
		
		//Move only in 3 directions
		if(isEdge(i,j,map.length, map[0].length)){
			if(i == 0){
				int countWest = map[i][j] > map[i][j-1] ? longestSkiUtil(map, aux, i, j-1) : -1;
				int countEast = map[i][j] > map[i][j+1] ? longestSkiUtil(map, aux, i, j+1) : -1;
				int countSouth = map[i][j] > map[i+1][j] ? longestSkiUtil(map, aux, i+1, j) : -1;
				aux[i][j] = 1 + Math.max(countWest, Math.max(countEast, countSouth));
				return aux[i][j];
			} else if(i == map.length -1){
				int countWest = map[i][j] > map[i][j-1] ? longestSkiUtil(map, aux, i, j-1) : -1;
				int countEast = map[i][j] > map[i][j+1] ? longestSkiUtil(map, aux, i, j+1) : -1;
				int countNorth = map[i][j] > map[i-1][j] ? longestSkiUtil(map, aux, i-1, j) : -1;
				aux[i][j] = 1 + Math.max(countWest, Math.max(countEast, countNorth));
				return aux[i][j];
			} else if(j == 0) {
				int countEast = map[i][j] > map[i][j+1] ? longestSkiUtil(map, aux, i, j+1) : -1;
				int countSouth = map[i][j] > map[i+1][j] ? longestSkiUtil(map, aux, i+1, j) : -1;
				int countNorth = map[i][j] > map[i-1][j] ? longestSkiUtil(map, aux, i-1, j) : -1;
				aux[i][j] = 1 + Math.max(countSouth, Math.max(countEast, countNorth));
				return aux[i][j];
			}else {
				int countWest = map[i][j] > map[i][j-1] ? longestSkiUtil(map, aux, i, j-1) : -1;
				int countSouth = map[i][j] > map[i+1][j] ? longestSkiUtil(map, aux, i+1, j) : -1;
				int countNorth = map[i][j] > map[i-1][j] ? longestSkiUtil(map, aux, i-1, j) : -1;
				aux[i][j] = 1 + Math.max(countWest, Math.max(countSouth, countNorth));
				return aux[i][j];
			}
		}
		
		//Move in all 4 directions
		int countEast = map[i][j] > map[i][j+1] ? longestSkiUtil(map, aux, i, j+1) : -1;
		int countWest = map[i][j] > map[i][j-1] ? longestSkiUtil(map, aux, i, j-1) : -1;
		int countSouth = map[i][j] > map[i+1][j] ? longestSkiUtil(map, aux, i+1, j) : -1;
		int countNorth = map[i][j] > map[i-1][j] ? longestSkiUtil(map, aux, i-1, j) : -1;
		aux[i][j] = 1 + Math.max(Math.max(countEast, countWest), Math.max(countSouth, countNorth));
		return aux[i][j];
		
	}
	
	private static void initializeAux(int[][] matrix){
		for(int i = 0 ; i < matrix.length; i++){
			for(int j = 0 ; j < matrix[0].length ; j++){
				matrix[i][j] = -1;
			}
		}
	}
	
	private static boolean isCorner(int i, int j, int rows, int columns){
		if(i == 0 || i == rows - 1){
			if(j == 0 || j == columns-1){
				return true;
			}
		}
		return false;
	}
	
	private static boolean isEdge(int i, int j, int rows, int columns){
		if((((i == 0 || i == rows -1) && (j > 0 && j <= columns - 1)) || (((j == 0 || j == columns -1) && (i > 0 && i <= rows - 1) )))){
			return true;
		}
		return false;
	}
	
	private static List<Pair> findMaxLongest(int[][] matrix){
		int largest = -1;
		Pair pair = new Pair();
		List<Pair> list = new LinkedList<>();
		list.add(pair);
		for(int i = 0 ; i < matrix.length ; i++){
			for(int j = 0 ; j < matrix[0].length ; j++){
				if(matrix[i][j] > largest){
					largest = matrix[i][j];
					pair.setI(i);
					pair.setJ(j);
				} else if(matrix[i][j] == largest){
					Pair duplicate = new Pair(i,j);
					list.add(duplicate);
				}
			}
		}
		Pair longest = new Pair(largest+1, -1);
		list.add(longest);
		return list;
	}
	
	private static void findMaxDepth(int[][] map, List<Pair> list, int longest){
		for(Pair pair : list){
			int i = pair.getI();
			int j = pair.getJ();
			int start = map[i][j];
			
			
		}
		
	}
	
	static class Pair {
		int i;
		int j;
		
		public Pair(){
			
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
