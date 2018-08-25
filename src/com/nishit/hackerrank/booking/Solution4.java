package com.nishit.hackerrank.booking;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution4 {

	public static void main(String[] args) {
		String keywords = "breakfast beach citycenter location metro view staff price";
		List<Integer> hotel_ids = new LinkedList<>();
		hotel_ids.add(1);
		hotel_ids.add(2);
		hotel_ids.add(1);
		hotel_ids.add(1);
		hotel_ids.add(2);
		List<String> reviews = new LinkedList<>();
		reviews.add("This hotel has a nice view of the citycenter. The location is perfect.");
		reviews.add("The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.");
		reviews.add("Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.");
		reviews.add("They said I couldn't take my dog and there were other guests with dogs! That is not fair.");
		reviews.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");
		sort_hotels(keywords, hotel_ids, reviews);
	}
	
	private static Set<String> addKeyWordsToSet(String[] keywordsArray){
		Set<String> keyWords = new HashSet<>(); 
		
		for(String keyword : keywordsArray){
			StringBuilder builder = new StringBuilder();
			Character start = keyword.charAt(0);
			builder.append(start.toUpperCase(start));
			builder.append(keyword.substring(1));
			keyWords.add(keyword);
			keyWords.add(builder.toString());
		}
		
		return keyWords;
	}
	
	static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids, List<String> reviews) {
		new HashSet<>();
		
		Map<Integer, Integer> hotelKeyWordCountMap = new HashMap<>();

		
		String[] keywordsArray = keywords.split(" ");
		
		Set<String> keyWords = addKeyWordsToSet(keywordsArray);
		
		countKeyWordsInReviewAndAddToHotelCount(reviews, hotel_ids, keyWords, hotelKeyWordCountMap);
		
		
		List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(hotelKeyWordCountMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
		Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        List<Integer> returnList = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entrySet : sortedMap.entrySet()){
        	returnList.add(entrySet.getKey());
        }
        return returnList;
    }
	
	public static void countKeyWordsInReviewAndAddToHotelCount(List<String> reviews, List<Integer> hotel_ids, Set<String> keyWords, Map<Integer, Integer> hotelKeyWordCountMap) {
		for(int i = 0 ; i < reviews.size() ; i++){
			int hotelId = hotel_ids.get(i);
			int count = 0;
			String[] reviewWords = reviews.get(i).split("[.,\\s]");
			for(String reviewWord : reviewWords){
				if(keyWords.contains(reviewWord)){
					count++;
				}
			}
			if(hotelKeyWordCountMap.containsKey(hotelId)){
				int currentCount = hotelKeyWordCountMap.get(hotelId);
				hotelKeyWordCountMap.put(hotelId, currentCount + count);
			} else {
				hotelKeyWordCountMap.put(hotelId, count);
			}
		}
	}

}
