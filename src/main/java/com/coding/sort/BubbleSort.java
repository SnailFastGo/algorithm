package com.coding.sort;

import com.coding.util.DataUtil;

public class BubbleSort implements Sort{
	public void sort(int[] source){
		if(null == source || source.length == 1){
			return;
		}
		
		for(int i = 0; i < source.length; i ++){
			for(int j = source.length - 1; j > i; j --){
				if(source[j] < source[j - 1]){
					DataUtil.swap(source, j, j - 1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		DataUtil.sortTest(bs);
	}
}
