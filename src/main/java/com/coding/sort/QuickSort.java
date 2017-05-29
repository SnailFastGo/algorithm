package com.coding.sort;

import com.coding.util.DataUtil;

public class QuickSort implements Sort{

	@Override
	public void sort(int[] source) {
		if(null == source || source.length == 1){
			return;
		}
		sort(source, 0, source.length - 1);
	}
	
	private void sort(int[] source, int lo, int hi){
		if(lo >= hi){
			return;
		}
		int i = lo;
		int j = hi;
		int k = source[i];
		while(i < j){
			while(i < j && source[j] > k){
				j --;
			}
			if(i < j){
				source[i] = source[j];
				i ++;
			}
			while(i < j && source[i] < k){
				i ++;
			}
			if(i < j){
				source[j] = source[i];
				j --;
			}
		}
		source[i] = k;
		sort(source, lo, i - 1);
		sort(source, i + 1, hi);
	}
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		for(int i = 0; i < 2; i++){
			DataUtil.sortTest(qs);
		}
	}
}
