package com.np.dsa.crux;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.np.dsa.utils.ScannerUtils;

public class SortArrayBasisOtherArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] elementArray = ScannerUtils.scanForIntArray(scanner);
		int[] orderArray = ScannerUtils.scanForIntArray(scanner);
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		scanner.close();
		for(int i =0 ; i< elementArray.length ; i++){
			if(map.containsKey(elementArray[i])){
				map.put(elementArray[i], map.get(elementArray[i])+1);
			}
			else{
				map.put(elementArray[i], 1);
			}
		}
		for(int i = 0; i< orderArray.length ; i++){
			int value = orderArray[i];
			if(map.containsKey(value)){
				int k = map.get(value);
				for(int j = 0 ; j < k; j++){
					System.out.print(orderArray[i] + ",");
				}
			}
			map.remove(orderArray[i]);
		}
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			for(int j = 0 ; j < entry.getValue() ; j++){
				System.out.print(entry.getKey() + ",");
			}
		}
	}
}
