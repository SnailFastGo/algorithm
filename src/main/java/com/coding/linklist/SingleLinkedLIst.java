package com.coding.linklist;

public class SingleLinkedLIst {
	
	private Node first;
	
	private static class Node{
		Object value;
		
		Node next;
		
		
	}
	
	public SingleLinkedLIst(){
		
	}
	
	
	public void addFirst(Object value){
		Node newNode = new Node();
		newNode.value = value;
		Node temp = first;
		first = newNode;
		first.next = temp;
	}
	
	public void addLast(Object value){
		if(first == null){
			Node newNode = new Node();
			newNode.value = value;
			first = newNode;
			return;
		}
		
		Node cur = first;
		while(cur.next != null){
			cur = cur.next;
		}
		Node newNode = new Node();
		newNode.value = value;
		cur.next = newNode;
		cur = newNode;
		return;
	}
	
	public void addBeforeNode(Node p, Object value) throws Exception{
		if(null == first){
			throw new Exception("头节点为空");
		}
		
		Node cur = first;
		while(!cur.next.equals(p)){
			cur = cur.next;
		}
		
		Node newNode = new Node();
		newNode.value = value;
		newNode.next = p;
		cur.next = newNode;
	}
	
	public void addAfterNode(Node p, Object value){
		Node newNode = new Node();
		newNode.value = value;
		newNode.next = p.next;
		p.next = newNode;
	}
	
	public Object removeFirst(){
		if(null == first){
			return null;
		}
		
		Node node = first;
		first = first.next;
		node.next = null;
		return node.value;
	}
	
	public Object removeLast(){
		if(null == first){
			return null;
		}
		
		if(null == first.next){
			Node res = first;
			first = null;
			return res;
		}
		Node cur = first;
		while(cur.next.next != null){
			cur = cur.next;
		}
		
		 Node res = cur.next;
		 cur.next = null;
		 return res;
	}
	
	public Object getFirst(){
		if(first == null){
			return null;
		}
		Node node = first;
		Object value = node.value;
		return value;
	}
	
	public int getLength(){
		int count = 0;
		Node cur = first;
		while(cur != null){
			count ++;
			cur = cur.next;
		}
		return count;
	}
	
	public void traversal(){
		Node cur = first;
		while(cur != null){
//			do something
			System.out.println(String.valueOf(cur.value));
			cur = cur.next;
		}
	}
	
	public void inverse(){
		Node node = null;
		while(first != null){
			Node temp = first;
			first = first.next;
			temp.next = node;
			node = temp;
		}
		first = node;
	}
	
	public static void main(String[] args) {
		SingleLinkedLIst sll = new SingleLinkedLIst();
		sll.addFirst("a");
		sll.addFirst("b");
		sll.addFirst("c");
		sll.addFirst("d");
		sll.traversal();
		sll.inverse();
		sll.traversal();
		sll.inverse();
		sll.traversal();
	}
}
