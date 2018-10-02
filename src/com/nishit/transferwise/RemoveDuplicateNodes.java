package com.nishit.transferwise;

import java.util.HashSet;
import java.util.Set;

class Node {
	int val;
	Node next;
}

public class RemoveDuplicateNodes {

	public Node distinct(Node head){
		if(head == null){
			return head;
		}
		Node prev = null;
		Node curr = head;
		Set<Integer> set = new HashSet<>();
		while(curr != null){
			if(set.contains(curr.val)){
				prev.next = curr.next;
			} else {
				set.add(curr.val);
				prev = curr;
			}
			curr = curr.next;
		}
		return head;
	}
}
