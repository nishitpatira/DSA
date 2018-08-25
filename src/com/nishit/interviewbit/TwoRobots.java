package com.nishit.interviewbit;

//https://www.hackerrank.com/challenges/two-robots/problem
public class TwoRobots {

	public static void main(String[] args) {
		final int m = 5;
		final int queries[][] = {{1,5},
				{3,2},
				{4,1},
				{2,4},
		};
		System.out.println(twoRobots(m, queries));

	}

	public static int twoRobots(int m , int[][] queries){
		int distance = 0;
		int rACoordinate = queries[0][1];
		int rBCoordinate = queries[1][1];
		distance += Math.abs(queries[0][0] - queries[0][1]);
		distance += Math.abs(queries[1][0] - queries[1][1]);

		for(int i = 2 ; i < queries.length ; i++){
			if(Math.abs(queries[i][0] - rACoordinate) < Math.abs(queries[i][0] - rBCoordinate)){
				distance += Math.abs(queries[i][0] - rACoordinate);
				rACoordinate = queries[i][1];
			} else {
				distance += Math.abs(queries[i][0] - rBCoordinate);
				rBCoordinate = queries[i][1];
			}
			distance += Math.abs(queries[i][0] - queries[i][1]);
		}
		return distance;
	}

}
