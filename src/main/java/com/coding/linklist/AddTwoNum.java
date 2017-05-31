package com.coding.linklist;

/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNum {
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(null == l1){
        	return l2;
        }
        
        if(null == l2){
        	return l1;
        }
        
        int carries = 0;
        ListNode temp = null;
        ListNode head = null;
        while(l1 != null && l2 != null){
        	int sum = l1.val + l2.val + carries;
        	int val = sum % 10;
        	carries = sum / 10;
        	ListNode newNode = new ListNode(val);
        	if(null == temp){
        		temp = newNode;
        		head = newNode;
        	}else{
        		temp.next = newNode;
        		temp = temp.next;
        	}
        	l1 = l1.next;
        	l2 = l2.next;
        }
        
        while(l1 != null){
        	int sum = l1.val + carries;
        	int val = sum % 10;
        	carries = sum / 10;
        	ListNode newNode = new ListNode(val);
        	temp.next = newNode;
    		temp = temp.next;
    		l1 = l1.next;
        }
        
        while(l2 != null){
        	int sum = l2.val + carries;
        	int val = sum % 10;
        	carries = sum / 10;
        	ListNode newNode = new ListNode(val);
        	temp.next = newNode;
    		temp = temp.next;
    		l2 = l2.next;
        }
        
        if(carries != 0){
        	ListNode newNode = new ListNode(carries);
        	temp.next = newNode;
        }
        return head;
    }
	

	private  class ListNode{
		int val;
		
		private ListNode next;
		
		private ListNode(int x){
			this.val = x;
		}
		
	}
		
}

