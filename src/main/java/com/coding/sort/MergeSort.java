package com.coding.sort;

import com.coding.util.DataUtil;

public class MergeSort implements Sort{

	@Override
	public void sort(int[] source) {
		if(null == source || source.length == 1){
			return;
		}
		int[] temp = new int[source.length];
		sort(source, 0, source.length - 1, temp);
	}
	
	private void sort(int[] source, int lo, int hi, int[] temp){
		if(lo >= hi){
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(source, lo, mid, temp);
		sort(source, mid + 1, hi, temp);
		merge(source, lo, mid, hi, temp);
	}
	
	private void merge(int[] source, int lo, int mid, int hi, int[] temp){
		int i = lo;
		int j = mid + 1;
		for(int k = lo; k<= hi; k ++){
			temp[k] = source[k];
		}
		for(int k = lo; k <= hi; k ++){
			if(i > mid){
				source[k] = temp[j++];
			}else if(j > hi){
				source[k] = temp[i++];
			}else if(temp[i] > temp[j]){
				source[k] = temp[j++];
			}else{
				source[k] = temp[i++];
			}
		}
	}
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		for(int i = 0; i < 10; i++){
			DataUtil.sortTest(ms);
		}
	}
}
