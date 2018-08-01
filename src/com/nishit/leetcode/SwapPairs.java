package com.nishit.leetcode;

public class SwapPairs {
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
		ListNode newHead = swapPairs(head);
		printList(newHead);

	}

	public static ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode next = head.next.next;
		ListNode newHead;
		head.next.next = head;
		newHead = head.next;
		head.next = swapPairs(next);
		return newHead;
	}
	
	public static void printList(ListNode head){
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

}