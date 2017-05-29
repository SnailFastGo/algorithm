package com.coding.stack;

import java.util.Arrays;
import java.util.Stack;

import com.coding.util.DataUtil;

/**使用栈实现getMin()
 * @author snailfast
 *
 */
public class StackForGetMin {
	private Stack dataStack = new Stack();
	private Stack orderStack = new Stack();

	public void push(Object data){
		dataStack.push(data);
		if(orderStack.isEmpty()){
			orderStack.push(data);
		}else{
			Object min = orderStack.peek();
			if(Integer.parseInt(String.valueOf(data)) <= Integer.parseInt(String.valueOf(min))){
				orderStack.push(data);
			}
		}
	}
	
	public Object pop(){
		if(dataStack.isEmpty()){
			return null;
		}
		Object ans = dataStack.pop();
		Object min = orderStack.peek();
		if(ans.equals(min)){
			orderStack.pop();
		}
		return ans;
	}
	
	public Object getMin(){
		if(orderStack.isEmpty()){
			return null;
		}
		return orderStack.peek();
	}
	
	
	public static void main(String[] args) {
		StackForGetMin sfg = new StackForGetMin();
		int[] dataArray = DataUtil.produceRandomArray(10, 100);
		System.out.println(Arrays.toString(dataArray));
		for(int i = 0; i < dataArray.length; i ++){
			sfg.push(dataArray[i]);
		}
		
		for(int i = 0; i < dataArray.length; i ++){
			System.out.println("第" + (i+1) + "次获取最小值：" + sfg.getMin());
			System.out.println("第" + (i+1) + "一次pop出的数据：" + sfg.pop());
		}
		
		System.out.println(sfg.pop());
		System.out.println(sfg.getMin());
		
	}
}
