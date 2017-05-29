package com.coding.queue;

import com.coding.util.DataUtil;

public class PriorityQueueByHeap {
	
	private int[] data;
	
	private int N = 0;
	
	public PriorityQueueByHeap(int capacity){
		data = new int[capacity + 1];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	
	private void swim(int k){
		while(k > 1 && data[k] > data[k / 2]){
			DataUtil.swap(data, k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k){
		while(2 * k <= N){
			int j = 2 * k;
			if(j < N && data[j] < data[j + 1]){
				j ++;
			}
			if(data[k] >= data[j]){
				break;
			}
			DataUtil.swap(data, k, j);
			k = j;
		}
	}
	
	public void insert(int i){
		data[++N] = i;
		this.swim(N);
	}
	
	public int delMax(){
		int max = data[1];
		DataUtil.swap(data, 1, N);
		
//		如果数组中的元素不是基本类型，则要将该元素在数组中的引用设置为null，以便jvm能及时回收
//		data[N] = null;
		N --;
		this.sink(1);
		return max;
	}
}
