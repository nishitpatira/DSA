package com.nishit.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/keys-and-rooms/description/
public class KeysAndRooms {
	public static void main(String[] args) {
		KeysAndRooms obj = new KeysAndRooms();
		List<List<Integer>> rooms = new LinkedList<>();
		List<Integer> room0 = new LinkedList<>();
		List<Integer> room1 = new LinkedList<>();
		List<Integer> room2 = new LinkedList<>();
		List<Integer> room3 = new LinkedList<>();
		rooms.add(room0);
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		room0.add(1);
		room0.add(3);
		room1.add(3);
		room1.add(0);
		room1.add(1);
		room2.add(2);
		room3.add(0);
		
		/*room0.add(1);
		room1.add(2);
		room2.add(3);*/
		
		
		System.out.println(obj.canVisitAllRooms(rooms));
		
	}
	
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		List<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		visited.add(0);
		List<Integer> roomsAtLevel = rooms.get(0);
		queue.addAll(roomsAtLevel);
		int i = 0;
		while(i != queue.size()){
			int room = queue.get(i);
			List<Integer> roomsAtLeveli = rooms.get(room);
			for(int elem : roomsAtLeveli){
				if(!queue.contains(elem)){
					queue.add(elem);
				}
			}
			visited.add(room);
			i++;
		}
		return visited.size() == rooms.size() ? true : false;
    }
}
