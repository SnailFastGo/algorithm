package com.coding.queue;

import java.util.Arrays;
import java.util.LinkedList;

public class WindowMaxValue {
	
	public int[] generateArr(int[] source, int windowLength){
		if(null == source || windowLength < 1 || source.length < windowLength){
			return null;
		}
		int sourceLength = source.length;
		int[] res = new int[sourceLength - windowLength + 1];
		int resIndex = 0;
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		for(int i = 0 ; i < sourceLength; i ++){
			while(!qmax.isEmpty() && source[qmax.peekLast()] <= source[i]){
				qmax.pollLast();
			}
			qmax.addLast(i);
			
			if(qmax.peekFirst() == i - windowLength){
				qmax.pollFirst();
			}
			
			if(i >= windowLength - 1){
				res[resIndex++] = source[qmax.peekFirst()];
			}
			
		}
		
		return res;
	}
	
	public static void main (String[] args) {
		int[] test = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
		WindowMaxValue wmv = new WindowMaxValue();
		int[] generateArr = wmv.generateArr(test, 3);
		System.out.println(Arrays.toString(generateArr));
	}
}
