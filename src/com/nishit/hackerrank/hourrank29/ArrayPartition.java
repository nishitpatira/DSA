package com.nishit.hackerrank.hourrank29;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ArrayPartition {
	
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		list.add(3);
		list.add(2);
		list.add(6);
		list.add(1);
		System.out.println(solve(list));
	}
	
	public static int solve(List<Integer> a){
		List<Integer> count = new LinkedList<>();
		solve(a, new LinkedList<Integer>(), count);
		return count.size();
	}
	
	private static void solve(List<Integer> list, List<Integer> aux, List<Integer> count){
		if(list.isEmpty()){
			return;
		}
		if(findGCD(list, aux) == 1){
			count.add(1);
		}
		ListIterator<Integer> iterator = list.listIterator();
		while(iterator.hasNext()){
			int element = iterator.next();
			aux.add(element);
			iterator.remove();
			List<Integer> tempList = new LinkedList<>(list);
			List<Integer> tempAux = new LinkedList<>(aux);
			solve(tempList, tempAux, count);
			aux.remove(aux.size()-1);
			tempList.add(element);
			list = tempList;
			//tempAux.remove(aux.size()-1);
			//tempList.add(element);
		}
		
	}
	
	private static int findGCD(List<Integer>list, List<Integer> aux){
		if(list.isEmpty() || aux.isEmpty()){
			return 0;
		}
		int listProduct = 1;
		int auxProduct = 1;
		for(Integer elem : list){
			listProduct = listProduct * elem;
		}
		for(Integer elem : aux){
			auxProduct = auxProduct * elem;
		}
		int gcd = findGCD(listProduct, auxProduct);
		return gcd == 1 ? 1 : 0;
	}
	
	private static int findGCD(int num1, int num2){
		int bigger = num1 > num2 ? num1 : num2;
		int smaller = num1 > num2 ? num2 : num1;
		int temp = 0;
		if(bigger == smaller){
			return smaller;
		}
		while(smaller != 1){
			bigger = bigger - smaller;
			if(bigger < smaller){
				temp = bigger;
				bigger = smaller;
				smaller = temp;
			}
			if(bigger == smaller){
				return smaller;
			}
		}
		return 1;
	}
	

}
