package com.nishit.interviewbit;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class LinkedListCycle {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = head;
		System.out.println(detectCycle(head).val);
		
	}
	
	public static ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null || head.next.next == null){
			return null;
		}
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		while(slow != fast){
			if(fast.next == null || fast.next.next == null){
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;	
		}
		return findBeginning(head, fast);
	}
	
	public static ListNode findBeginning(ListNode head, ListNode fast){
		ListNode temp = head;
		while(temp != fast){
			temp = temp.next;
			fast = fast.next;
		}
		return temp;
		
	}
}
