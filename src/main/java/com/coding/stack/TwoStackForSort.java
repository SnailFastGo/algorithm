package com.coding.stack;

import java.util.Arrays;
import java.util.Stack;

import com.coding.util.DataUtil;

public class TwoStackForSort {
	public void stackSort(Stack<Integer> stack){
		if(null == stack || stack.isEmpty()){
			return;
		}
		Stack<Integer> help = new Stack<Integer>();
		while(!stack.isEmpty()){
			int cur = stack.pop();
			while(!help.isEmpty() && help.peek() < cur){
				stack.push(help.pop());
			}
			help.push(cur);
		}
		
		while(!help.isEmpty()){
			stack.push(help.pop());
		}
	}
	
	public static void main(String[] args) {
		int[] testData = DataUtil.produceRandomArray(10, 100);
		System.out.println(Arrays.toString(testData));
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < testData.length; i ++){
			stack.push(testData[i]);
		}
		System.out.println(stack);
		
		TwoStackForSort tsfs = new TwoStackForSort();
		tsfs.stackSort(stack);
		
		System.out.println(stack);
	}
	
}
