package com.coding.sort;

import com.coding.util.DataUtil;

public class SelectSort implements Sort{
	
	public void sort(int[] source){
		if(null == source || source.length == 1){
			return;
		}
		
		for(int i = 0; i < source.length; i ++){
			for(int j = i + 1; j < source.length; j ++){
				if(source[i] > source[j]){
					DataUtil.swap(source, i, j);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		SelectSort ss = new SelectSort();
		DataUtil.sortTest(ss);
	}
}
