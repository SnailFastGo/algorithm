package com.coding.util;

import java.util.Arrays;
import java.util.Random;

import com.coding.sort.BubbleSort;
import com.coding.sort.Sort;

public class DataUtil {
	public static int[] produceRandomArray(int length, int limit){
		int[] res = new int[length];
		Random random = new Random();
		for(int i = 0; i < length; i ++){
			int temp = random.nextInt(limit);
			res[i] = temp;
		}
		return res;
	}
	
	public static void swap(int[] source, int x, int y){
		int temp = source[x];
		source[x] = source[y];
		source[y] = temp;
	}
	
	public static void sortTest(Sort sort){
		int[] data = DataUtil.produceRandomArray(100000, 10000);
//		System.out.println(Arrays.toString(data));
		long start = System.currentTimeMillis();
		sort.sort(data);
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start));
//		System.out.println(Arrays.toString(data));
	}
	
	public static void main(String[] args) {
		int[] produceRandomArray = produceRandomArray(10, 1000);
		System.out.println(Arrays.toString(produceRandomArray));
	}
}
