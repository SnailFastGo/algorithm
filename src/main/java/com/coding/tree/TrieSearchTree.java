package com.coding.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TrieSearchTree {
	private static int R = 256;
	
	private Node root;
	
	private static class Node{
		Object value;
		Node[] next = new Node[R];
		
	}
	
	public Object get(String key){
		Node x = get(root, key, 0);
		if(x == null){
			return null;
		}
		return x.value;
	}
	
	private Node get(Node x, String key, int d){
		if(x == null){
			return null;
		}
		
		if(key.length() == d){
			return x;
		}
		
		char c = key.charAt(d);
		return get(x.next[c], key, d+1);
	}
	
	public void put(String key, String value){
		root = put(root, key, value, 0);
	}
	
	private Node put(Node x, String key, String value, int d){
		if(x == null){
			x = new Node();
		}
		if(key.length() == d){
			x.value = value;
			return x;
		}
		
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, value, d+1);
		return x;
	}
	
	public Iterable<String> keys(){
		return keysWithPreFix("");
	}
	
	public Iterable<String> keysWithPreFix(String pre){
		Queue<String> queue = new LinkedList<String>();
		Node node = get(root, pre, 0);
		collect(node, pre, queue);
		return queue;
	}
	
	private void collect(Node x, String pre, Queue<String> queue){
		if(x == null){
			return;
		}
		
		if(x.value != null){
			queue.add(pre);
		}
		
		for(char c = 0; c < R; c ++){
			collect(x.next[c], pre + c, queue);
		}
	}
	
	
	
	public static void main(String[] args) {
		TrieSearchTree tst = new TrieSearchTree();
		tst.put("abc", "123");
		tst.put("bad", "234");
		tst.put("abd", "345");
		
		System.out.println(tst.get("abc"));
		System.out.println(tst.get("bad"));
		System.out.println(tst.get("qcb"));
		System.out.println(tst.get("qwe"));
		
		Iterable<String> keys = tst.keysWithPreFix("ab");
		for(String key : keys){
			System.out.println(key);
		}
	}
	
	
}
