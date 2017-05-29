package com.coding.sort;

import java.util.Arrays;

import com.coding.util.DataUtil;

/** 将整数数组排序，排序结果要求把所有数字拼接起来组成的整数最小
 * 如原组[3, 83, 8, 13, 1], 排序之后[1, 13, 3, 83, 8]，因为 1133838最小
 * @author snailfast
 *
 */
public class ArraySplitJoint {
	
	public static void main(String[] args) {
		int[] test = {3, 83, 8, 13, 1};
		ArraySplitJoint asj = new ArraySplitJoint();
		asj.sort(test);
		System.out.println(Arrays.toString(test));
	}
	
	public void sort(int[] source){
		if(null == source || source.length == 1){
			return;
		}
		
		for(int i = 0; i < source.length; i ++){
			for(int j = source.length - 1; j > i; j --){
				if(less(source[j], source[j - 1])){
					DataUtil.swap(source, j, j - 1);
				}
			}
		}
	}
	
	public boolean less(int x, int y){
		String xStr = String.valueOf(x);
		String yStr = String.valueOf(y);
		int tempXY = Integer.parseInt(xStr + yStr);
		int tempYX = Integer.parseInt(yStr + xStr);
		if(tempXY <= tempYX){
			return true;
		}else{
			return false;
		}
	}
}
