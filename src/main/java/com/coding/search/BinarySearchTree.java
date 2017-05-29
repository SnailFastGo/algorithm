package com.coding.search;

import java.util.HashSet;
import java.util.Set;

public class BinarySearchTree {
	
	private Node root;
	
	private class Node{
		int key;
		Object value;
		Node left;
		Node right;
		int N;
		
		public Node(int key, Object value){
			this.key = key;
			this.value = value;
			this.N = 1;
		}
	}
	
	public int size(){
		return size(root);
	}
	
	private int size(Node x){
		if(null == x){
			return 0;
		}
		return x.N;
	}
	
	public Object get(int key){
		return get(root, key);
	}
	
	private Object get(Node x, int key){
		if(x == null){
			return null;
		}
		if(key == x.key){
			return x.value;
		}else if(key < x.key){
			return get(x.left, key);
		}else{
			return get(x.right, key);
		}
	}
	
	public void put(int key, Object value){
		root = put(root, key, value);
	}
	
	private Node put(Node x, int key, Object value){
		if(x == null){
			return new Node(key, value);
		}
		if(key == x.key){
			x.value = value;
		}else if(key < x.key){
			x.left = put(x.left, key, value);
		}else{
			x.right = put(x.right, key, value);
		}
		x.N = x.left.N + x.right.N + 1;
		return x;
	}
	
	public int getMax() throws Exception{
		if(null == root){
			throw new Exception("根结点为空，不存在最大key");
		}
		return getMax(root);
	}
	
	private int getMax(Node x){
		if(null == x.right){
			return x.key;
		}
		return getMax(x.right);
	}
	
	public int getMin()throws Exception{
		if(null == root){
			throw new Exception("根结点为空，不存在最小key");
		}
		return getMin(root);
	}
	
	private int getMin(Node x){
		if(null == x.left){
			return x.key;
		}
		return getMin(x.left);
	}
	
	public void midPrint(){
		midPrint(root);
	}
	
	private void midPrint(Node x){
		if(null != x){
			midPrint(x.left);
			System.out.println(x.key);
			midPrint(x.right);
		}
	}
	
	public Set<Integer> keys(int  minKey, int maxKey){
		Set<Integer> set = new HashSet<Integer>();
		keys(root, set, minKey, maxKey);
		return set;
		
	}
	
	private void keys(Node x, Set<Integer> set, int minKey, int maxKey){
		if(null == x){
			return;
		}
		if(x.key > minKey){
			keys(x.left, set, minKey, maxKey);
		}
		if(x.key >= minKey && x.key <= maxKey){
			set.add(x.key);
		}
		if(x.key < maxKey){
			keys(x.right, set, minKey, maxKey);
		}
	}
}





