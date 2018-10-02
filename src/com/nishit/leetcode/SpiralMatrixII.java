package com.nishit.leetcode;

public class SpiralMatrixII {
	
	public int[][] generateMatrix(final int n) {
        if( n < 0) return null;
        if(n == 0) return new int[0][0];
        
        final int[][] matrix = new int[n][n];
        
        int startRow = 0;
        int startColumn = 0;
        int endRow = n-1;
        int endColumn = n-1;
        int count = 1;
        while(startRow <= endRow && startColumn <= endColumn){
            for(int i = startColumn; i <= endColumn ; i++){
                matrix[startRow][i] = count;
                count++;
            }
            startRow++;
            
            for(int i = startRow; i <= endRow ; i++){
                matrix[i][endColumn] = count;
                count++;
            }
            endColumn--;
            
            for(int i = endColumn; i >= startColumn ; i--){
                matrix[endRow][i] = count;
                count++;
            }
            endRow--;
            
            for(int i = endRow; i >= startRow ; i--){
                matrix[i][startColumn] = count;
                count++;
            }
            startColumn++;
        }
        return matrix;
    }
	
	public static void main(String[] args) {
		SpiralMatrixII spiral = new SpiralMatrixII();
		int[][] matrix = spiral.generateMatrix(4);
		System.out.println();
		
	}

}
