package com.coding.stack;

import java.util.Arrays;
import java.util.Stack;

import com.coding.util.DataUtil;

/**使用递归逆序一个栈
 * @author snailfast
 *
 */
public class ReverseStackWithRecursion {
	
	/** 利用递归获取栈底元素
	 * @param stack
	 * @return
	 */
	public Integer getLastElement(Stack<Integer> stack){
		Integer pop = stack.pop();
		if(!stack.isEmpty()){
			Integer last = getLastElement(stack);
			stack.push(pop);
			return last;
		}
		return pop;
	}
	
	/** 利用递归逆序一个栈
	 * @param stack
	 */
	public void reverseStack(Stack<Integer> stack){
		if(stack.isEmpty()){
			return;
		}
		Integer lastElement = getLastElement(stack);
		reverseStack(stack);
		stack.push(lastElement);
	}
	
	public static void main(String[] args) {
		int[] dataArray = DataUtil.produceRandomArray(10, 100);
		System.out.println(Arrays.toString(dataArray));
		Stack<Integer> stack = new Stack<>();
		for(int i = 0 ; i < dataArray.length; i ++){
			stack.push(dataArray[i]);
		}
		ReverseStackWithRecursion rswr = new ReverseStackWithRecursion();
		rswr.reverseStack(stack);
		System.out.println(stack);
	}
	
	
}
