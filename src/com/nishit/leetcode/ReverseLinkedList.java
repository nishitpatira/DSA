package com.nishit.leetcode;

import com.nishit.leetcode.SwapPairs.ListNode;

public class ReverseLinkedList {
	
	private static ListNode newHead = null;
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		//ListNode node5 = new ListNode(5);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		//node5.next = null;
		reverseList(head);
		SwapPairs.printList(newHead);
	}
	
	private static ListNode reverseList(ListNode head){
		if(head.next == null){
			newHead = head;
			return head;
		}
		
		ListNode temp = reverseList(head.next);
		temp.next = head;
		head.next = null;
		return head;
		
	}

}
