package com.nishit.interviewbit;

public class RemoveDuplicatesFromLL {
	
	public static void main(String[] args) {
		
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode prev = head;
		ListNode curr = head.next;
		while(curr != null){
			if(prev.val == curr.val){
			} else {
				prev.next = curr;
				prev = curr;
			}
			curr = curr.next;
		}
		prev.next = curr;
		return head;
	}

}
