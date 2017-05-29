package com.coding.tree;

public class BinaryTree {
	
	Node root;
	
//	private int maxDepth;
//	
//	private Node maxDepthNode;
	
	private class Node{
		Object value;
		
		Node left;
		
		Node right;
	}
	
	/** 求二叉树的深度
	 * @return
	 */
	public int height(){
		return height(root);
	}
	
	private int height(Node node){
		if(null == node){
			return 0;
		}
		return height(root.left) + height(root.right) + 1;
	}
	
	/** 求二叉树深度最大的节点
	 * @return
	 */
	public Node getMaxDepthNode(){
		Node maxDepthNode = null;
		int maxDepth = -1;
		 getMaxDepthNode(root, 0, maxDepth, maxDepthNode);
		 return maxDepthNode;
	}
	
	private void getMaxDepthNode(Node node, int depth, int maxDepth, Node maxDepthNode){
		if(null == node){
			return;
		}
		
		if(depth > maxDepth){
			maxDepth = depth;
			maxDepthNode = node;
		}
		
		getMaxDepthNode(node.left, depth + 1, maxDepth, maxDepthNode);
		getMaxDepthNode(node.right, depth + 1, maxDepth, maxDepthNode);
	}
	
	/** 求二叉树的节点数
	 * @return
	 */
	public int nodeCount(){
		int count = nodeCount(root);
		return count;
	}
	
	private int nodeCount(Node node){
		if(null == node){
			return 0;
		}
		return nodeCount(node.left) + nodeCount(node.right) + 1;
	}
	
	/** 判断二叉树是否是满二叉树
	 * @return
	 */
	public boolean isFullBinaryTree(){
		int height = height(root);
		int count = nodeCount(root);
		return count == (1 << height) - 1;
	}
	
	/**
	 * 前序遍历
	 */
	public void preOrder(){
		preOrder(root);
	}
	private void preOrder(Node node){
		if(null == node){
			return;
		}
		System.out.println(String.valueOf(node));
		preOrder(node.left);
		preOrder(node.right);
	}
	
	/**
	 * 中序遍历
	 */
	public void inOrder(){
		inOrder(root);
	}
	
	private void inOrder(Node node){
		if(null == node){
			return;
		}
		inOrder(node.left);
		System.out.println(String.valueOf(node));
		inOrder(node.right);
	}
	
	/**
	 * 后序遍历
	 */
	public void postOrder(){
		postOrder(root);
	}
	
	private void postOrder(Node node){
		if(null == node){
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(String.valueOf(node));
	}
	
	public boolean isBlanced(){
		return isBlanced(root);
	}
	
	/** 由于每次递归都要重新计算节点的高度，所以可以将每个节点的高度用map缓存起来，避免重复计算
	 * @param node
	 * @return
	 */
	private boolean isBlanced(Node node){
		if(null == node){
			return true;
		}
		if(!isBlanced(node.left) || isBlanced(node.right)){
			return false;
		}
		
		return Math.abs(this.height(node.left) - this.height(node.right)) <= 1;
	}
	
}
