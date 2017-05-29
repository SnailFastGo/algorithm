package com.coding.sort;

import com.coding.util.DataUtil;

public class InsertSort implements Sort{

	@Override
	public void sort(int[] source) {
		if(null == source || source.length == 1){
			return;
		}
		for(int i = 1; i < source.length; i ++){
			for(int j = i; j > 0; j --){
				if(source[j] < source[j - 1]){
					DataUtil.swap(source, j, j - 1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		InsertSort is = new InsertSort();
		DataUtil.sortTest(is);
	}
	
}
