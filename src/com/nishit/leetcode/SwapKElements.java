package com.nishit.leetcode;

import java.util.Scanner;

import com.nishit.leetcode.SwapPairs.ListNode;
import com.np.dsa.utils.ScannerUtils;

public class SwapKElements {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = ScannerUtils.scanForNumber(scanner);
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
		ListNode newHead = swapKElements(head, k);
		SwapPairs.printList(newHead);
	}
	
	public static ListNode swapKElements(ListNode head, int k){
		ListNode temp = head;
		while(k > 0){
			if(temp != null){
				temp = head.next;
				k--;
			}
			else {
				return head;
			}
		}
		
		reverseSizeKList(head, k);
		return null;
	}
	
	private static ListNode reverseSizeKList(ListNode head, int k){
		ListNode temp = head;
		while ( k > 0 && temp.next != null){
			
		}
		return null;
	}
}
