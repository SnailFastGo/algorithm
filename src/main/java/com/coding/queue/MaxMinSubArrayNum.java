package com.coding.queue;

import java.util.LinkedList;

/**给定数组source， 求共返回多少个子数组满足如下情况：
 * max（source[i...j]）- min(source[i...j]) <= n
 *  max（source[i...j]表示子数组source[i...j]中的最大值，min(source[i...j])表示子数组中的最小值
 *  
 * @author snailfast
 *
 */
public class MaxMinSubArrayNum {
	public static void main(String[] args) {
		
	}
	
	public int getNum(int[] source, int n){
		if(null == source || source.length == 0){
			return 0;
		}
		
//		子数组中的最大值在source中的索引
		LinkedList<Integer> maxQue = new LinkedList<Integer>();
		
//		子数组中的最小值在source中的索引
		LinkedList<Integer> minQue = new LinkedList<Integer>();
		
//		子数组的左边界
		int i = 0;
		
//		子数组的右边界
		int j = 0;
		
//		满足条件的子数组个数
		int res = 0;
		
		while(i < source.length){
			while(j < source.length){
				
//				维护最大值索引队列
				while(!maxQue.isEmpty() && maxQue.peekFirst() <= source[j]){
					maxQue.pollLast();
				}
				maxQue.addLast(j);
				
//				维护最小值索引队列
				while(!minQue.isEmpty() && minQue.peekFirst() >= source[j]){
					minQue.pollLast();
				}
				minQue.addLast(j);
				
//				子数组满足条件即停止
				if(source[maxQue.peekFirst()] - source[minQue.peekFirst()] > n){
					break;
				}
				
//				子数组不满足条件的话，子数组的右边界就向右扩张
				j ++;
			}
			
//			如果子数组中的最大值在source中的索引为i，则从最大值索引队列中移除i，以为i在下一轮循环中已过期
			if(maxQue.peekFirst() == i){
				maxQue.pollFirst();
			}
			
//			如果子数组中的最小值在source中的索引为i，则从最大小值索引队列中移除i，以为i在下一轮循环中已过期
			if(minQue.peekFirst() == i){
				minQue.pollFirst();
			}
			
//			累加满足符合条件的子数组
			res += j - i;
		}
		
		return res;
	}
}
