package com.nishit.flowtrader.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		int x3 = scanner.nextInt();
		int y3 = scanner.nextInt();
		int p1 = scanner.nextInt();
		int q1 = scanner.nextInt();
		int p2 = scanner.nextInt();
		int q2 = scanner.nextInt();

		int res = pointsBelongToTriangle(x1, y1, x2, y2, x3, y3, p1, q1, p2, q2);
		System.out.println(res);
		scanner.close();
	}

	static int pointsBelongToTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int p1, int q1, int p2, int q2) {
		double ab = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
		double bc = Math.sqrt((x2 - x3)*(x2 - x3) + (y2 - y3)*(y2 - y3));
		double ca = Math.sqrt((x3 - x1)*(x3 - x1) + (y3 - y1)*(y3 - y1));

		if (ab + bc <= ca || ca + ab <= bc || bc + ca <= ab) {
			return 0;
		}

		boolean isPInTriangle = isPointInTriangle(x1, y1, x2, y2, x3, y3, p1, q1);
		boolean isQInTriangle = isPointInTriangle(x1, y1, x2, y2, x3, y3, p2, q2);
		if(isPInTriangle && !isQInTriangle){
			return 1;
		} else if(!isPInTriangle && isQInTriangle){
			return 2;
		} else if(isPInTriangle && isQInTriangle){
			return 3;
		} else {
			return 4;
		}

	}

	private static boolean isPointInTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
		double Area = area(x1, y1, x2, y2, x3, y3);
		double AreaA = area(x, y, x2, y2, x3, y3);
		double AreaB = area(x1, y1, x, y, x3, y3);
		double AreaC = area(x1, y1, x2, y2, x, y);

		return (Area == AreaA + AreaB + AreaC);
	}

	static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
		return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
	}

}
