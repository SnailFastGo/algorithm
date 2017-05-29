package com.coding.linklist;

/**
 * @author snailfast
 * 双向链表（并非循环链表，循环链表要首尾相连）
 */
public class DoubleLinkedList {
	private Node first;
	
	private Node last;
	
	private int size;
	
	private class Node{
		Object value;
		
		Node pre;
		
		Node next;
		
		public Node(Node pre, Object value, Node next){
			this.value = value;
			this.pre = pre;
			this.next = next;
		}
	}
	
	public void addFirst(Object value){
		Node temp = first;
		Node newNode = new Node(null, value, temp);
		first = newNode;
		if(temp == null){
			last = newNode;
		}else{
			temp.pre = newNode;
		}
		this.size ++;
	}
	
	public void addLast(Object value){
		Node temp = last;
		Node newNode = new Node(temp, value, null);
		last = newNode;
		if(temp == null){
			first = newNode;
		}else{
			temp.next = newNode;
		}
		this.size ++;
	}
	
	public void addBeforeNode(Node p, Object value){
		Node pre = p.pre;
		Node newNode = new Node(pre, value, p);
		p.pre = newNode;
		if(pre == null){
			first = newNode;
		}else{
			pre.next = newNode;
		}
		this.size ++;
	}
	
	public void addAfterNode(Node p, Object value){
		Node next = p.next;
		Node newNode = new Node(p, value, next);
		p.next = newNode;
		if(next == null){
			last = newNode;
		}else{
			last.pre = newNode;
		}
		
		this.size ++;
	}
	
	public Object removeFist(){
		if(null == first){
			return null;
		}
		Object res = first.value;
		Node next = first.next;
		first.value = null;
		first.next = null;
		first = next;
		if(next == null){
			last = null;
		}else{
			next.pre = null;
		}
		
		this.size --;
		return res;
	}
	
	public Object removeLast(){
		if(null == last){
			return null;
		}
		
		Object res = last.value;
		Node pre = last.pre;
		last.value = null;
		last.pre = null;
		last = pre;
		if(null == pre){
			first = null;
		}else{
			pre.next = null;
		}
		
		this.size --;
		return res;
	}
	
	public boolean removeFirstOccurrence(Object value){
		Node cur = first;
		if(null == value){
			while(cur != null){
				if(cur.value == null){
					remove(cur);
					return true;
				}
				cur = cur.next;
			}
		}else{
			while(cur != null){
				if(value.equals(cur.value)){
					remove(cur);
					return true;
				}
				cur = cur.next;
			}
		}
		
		return false;
	}
	
	public boolean removeLastOccurrence(Object  value){
		Node cur = last;
		if(null == value){
			while(cur != null){
				if(cur.value == null){
					remove(cur);
					return true;
				}
				cur = cur.pre;
			}
		}else{
			while(cur != null){
				if(value.equals(cur.value)){
					remove(cur);
					return true;
				}
				cur = cur.pre;
			}
		}
		
		return false;
	}
	
	private void remove(Node node){
		if(null == node){
			return;
		}
		Object value = node.value;
		Node pre = node.pre;
		Node next = node.next;
		if(null == pre){
			first = next;
		}else{
			pre.next = next;
			pre = null;
		}
		
		if(next == null){
			last = pre;
		}else{
			next.pre = pre;
			next = null;
		}
		
		value = null;
		this.size --;
		return;
	}
	public Object getFirst(){
		if(first == null){
			return null;
		}
		
		return first.value;
	}
	
	public Object getLast(){
		if(last == null){
			return null;
		}
		
		return last.value;
	}
	
	public int getLength(){
		return size;
	}
	
	public void traversal(){
		Node cur = first;
		while(cur != null){
//			do something
			cur = cur.next;
		}
	}
	
}
