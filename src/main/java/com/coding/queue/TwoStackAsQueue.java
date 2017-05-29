package com.coding.queue;

import java.util.Arrays;
import java.util.Stack;

import com.coding.util.DataUtil;

/** 使用两个栈模拟一个队列
 * @author snailfast
 *
 */
public class TwoStackAsQueue {
	private Stack<Integer> stackOne = new Stack<>();
	
	private Stack<Integer> stackTwo = new Stack<>();
	
	public boolean add(Integer data){
		return stackOne.add(data);
	}
	
	public Integer poll() throws Exception{
		if(stackTwo.isEmpty()){
			if(stackOne.isEmpty()){
				throw new Exception("队列已空，没有数据可弹出");
			}else{
				while(!stackOne.isEmpty()){
					Integer temp = stackOne.pop();
					stackTwo.push(temp);
				}
			}
		}
		return stackTwo.pop();
	}
	
	public Integer peek() throws Exception{
		if(stackTwo.isEmpty()){
			if(stackOne.isEmpty()){
				throw new Exception("队列已空，没有数据可弹出");
			}else{
				while(!stackOne.isEmpty()){
					Integer temp = stackOne.pop();
					stackTwo.push(temp);
				}
			}
		}
		return stackTwo.peek();
	}
	
	public static void main(String[] args) throws Exception {
		TwoStackAsQueue taq = new TwoStackAsQueue();
		int[] data = DataUtil.produceRandomArray(10, 100);
		System.out.println(Arrays.toString(data));
		for(int i = 0; i < 5; i ++){
			taq.add(data[i]);
		}
		for(int i = 0; i < 5; i ++){
			System.out.print(taq.poll());
			System.out.print(",");
		}
		
		for(int i = 5; i < 10; i ++){
			taq.add(data[i]);
		}
		
		for(int i = 5; i < 10; i ++){
			System.out.print(taq.poll());
			System.out.print(",");
		}
	}
}
