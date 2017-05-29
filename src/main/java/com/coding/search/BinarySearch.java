package com.coding.search;

import java.util.Arrays;

import com.coding.util.DataUtil;

public class BinarySearch {
	public int recursionSearch(int[] source, int lo, int hi, int key){
		if(lo > hi){
			return -1;
		}
		int mid = lo + (hi - lo) / 2;
		if(key == source[mid]){
			return mid;
		}else if(key < source[mid]){
			return recursionSearch(source, lo, mid - 1, key);
		}else{
			return recursionSearch(source, mid + 1, hi, key);
		}
			
	}
	
	public int noRecursionSearch(int[] source, int key){
		int lo = 0;
		int hi = source.length - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if(key == source[mid]){
				return mid;
			}else if( key < source[mid]){
				hi = mid - 1;
			}else{
				lo = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] source = DataUtil.produceRandomArray(10, 100);
		Arrays.sort(source);
		System.out.println(Arrays.toString(source));
		BinarySearch bs = new BinarySearch();
		int res = bs.recursionSearch(source, 0, source.length, source[3]);
		System.out.println(res);
	}
}
