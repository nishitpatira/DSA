package com.nishit.leetcode;

import com.nishit.leetcode.SwapPairs.ListNode;

public class ReverseLinkedList {

	private ListNode newHead = null;

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		// node5.next = null;
		ReverseLinkedList obj = new ReverseLinkedList();
		obj.reverseList(head);
		SwapPairs.printList(obj.newHead);
	}

	public ListNode reverseList(ListNode head) {
		if(head == null){
			return null;
		}
		reverseListUtil(head);
		head.next = null;
		return newHead;
	}

	private ListNode reverseListUtil(ListNode curr) {
		if (curr.next == null) {
			newHead = curr;
			return newHead;
		}
		ListNode temp = reverseListUtil(curr.next);
		temp.next = curr;
		return curr;
	}

	/*
	 * private static ListNode reverseList(ListNode head){ if(head.next ==
	 * null){ newHead = head; return head; } ListNode temp =
	 * reverseList(head.next); temp.next = head; head.next = null; return head;
	 * 
	 * }
	 */

}
