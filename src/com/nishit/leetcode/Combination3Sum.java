package com.nishit.leetcode;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/combination-sum-iii/description/

public class Combination3Sum {
	
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> returnList = new LinkedList<>();
        combinationUtil(k,n, new LinkedList<>(), returnList);
        return returnList;
    }
    
    private void combinationUtil(int k, int n, List<Integer> currentList, List<List<Integer>> fullList){
        if(n < 0 || k < 0) return;
        if(n == 0 && k == 0){
            List<Integer> list = new LinkedList<>();
            for(int elem : currentList){
                list.add(elem);
            }
            fullList.add(list);
        }
        int start = (currentList.size() == 0) ? 0 : currentList.get(currentList.size()-1);
        for(int i = start+1; i <= 9 ; i++){
            currentList.add(i);
            combinationUtil(k-1, n-i, currentList, fullList);
            currentList.remove(currentList.size()-1);
        }
    }

    public static void main(String[] args) {
		int k = 3;
		int n = 7;
		Combination3Sum obj = new Combination3Sum();
		obj.combinationSum3(k, n);
	}
}
