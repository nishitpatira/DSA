package com.nishit.swiggy;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TravelFun {

	public static List<Integer> connectedCities(int n, int g, List<Integer> originCities,
			List<Integer> destinationCities) {
		if (g == 0) {
			List<Integer> returnList = new LinkedList<>();
			for (int i = 0; i < originCities.size(); i++) {
				returnList.add(1);
			}
			return returnList;
		}
		Map<Integer, List<Integer>> associationMap = new HashMap<>(n);
		initializeMap(associationMap, n);
		findAssociation(associationMap, g, n);
		List<Integer> returnList = new LinkedList<>();
		sortEachList(associationMap);
		for (int i = 0; i < originCities.size(); i++) {
			int originCity = originCities.get(i);
			int destinationCity = destinationCities.get(i);
			boolean isPathPresent = doDFS(associationMap, originCity, destinationCity);
			if (isPathPresent) {
				returnList.add(1);
			} else {
				returnList.add(0);
			}
		}
		return returnList;
	}
	
	private static void sortEachList(final Map<Integer, List<Integer>> associationMap){
		for(List<Integer> list : associationMap.values()){
			Collections.sort(list);
			Collections.reverse(list);
		}
	}

	private static void initializeMap(final Map<Integer, List<Integer>> associationMap, final int n) {
		for (int i = 1; i <= n; i++) {
			List<Integer> gcdList = new LinkedList<>();
			associationMap.put(i, gcdList);
		}
	}

	private static void findAssociation(final Map<Integer, List<Integer>> associationMap, final int g, final int n) {
		for (int i = g; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				int gcd = findGCD(i, j);
				if (gcd > g) {
					associationMap.get(i).add(j);
					associationMap.get(j).add(i);
				}
			}
		}
	}

	private static boolean doDFS(final Map<Integer, List<Integer>> associationMap, final int originCity,
			final int destinationCity) {
		boolean[] isVisited = new boolean[associationMap.size() + 1];
		isVisited[0] = true;
		return doDFSUtil(associationMap, originCity, destinationCity, isVisited);
	}

	private static boolean doDFSUtil(final Map<Integer, List<Integer>> associationMap, final int originCity,
			final int destinationCity, final boolean[] isVisited) {
		if (originCity == destinationCity) {
			return true;
		}
		boolean isPathPresent = false;
		if (!isVisited[originCity]) {
			List<Integer> innerList = associationMap.get(originCity);
			isVisited[originCity] = true;
			for (int inner : innerList) {
				if (doDFSUtil(associationMap, inner, destinationCity, isVisited)) {
					isPathPresent = true;
					break;
				}
			}
		}
		return isPathPresent;
	}
	
	private static boolean doBFS(final Map<Integer, List<Integer>> associationMap, final int originCity,
			final int destinationCity){
		boolean[] isVisited = new boolean[associationMap.size() + 1];
		isVisited[0] = true;
		return doBFSUtil(associationMap, originCity, destinationCity, isVisited);
		
	}
	
	private static boolean doBFSUtil(final Map<Integer, List<Integer>> associationMap, final int originCity,
			final int destinationCity, final boolean[] isVisited){
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(originCity);
		while(!queue.isEmpty()){
			int city = queue.poll();
			if(city == destinationCity){
				return true;
			}
			if(!isVisited[city]){
				isVisited[originCity] = true;
				queue.addAll(associationMap.get(city));
			}
		}
		return false;
	}

	private static int findGCD(int i, int j) {
		if (i == 0 || j == 0) {
			return 0;
		}
		if(i == 1 || j == 1){
			return 1;
		}
		if (i == j) {
			return i;
		}
		if (i > j) {
			return findGCD(i - j, j);
		}
		return findGCD(i, j - i);

	}

	public static void main(String[] args) {
		List<Integer> originCities = new LinkedList<>();
		List<Integer> destinationCities = new LinkedList<>();
		originCities.add(1);
		originCities.add(2);
		originCities.add(4);
		originCities.add(6);
		destinationCities.add(3);
		destinationCities.add(3);
		destinationCities.add(3);
		destinationCities.add(4);
		int n = 6;
		int g = 1;
		List<Integer> returnList = connectedCities(n, g, originCities, destinationCities);
		System.out.println(returnList);

	}

}
