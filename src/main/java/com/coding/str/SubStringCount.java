package com.coding.str;

/** 给定原始字符串sourceStr和字串str， 求字串在原始字符串中出现的次数
 * @author snailfast
 *
 */
public class SubStringCount {
	public int i =10;
	public static void main(String[] args) {
		SubStringCount ssc = new SubStringCount();
		String sourceStr = "Your life is your own affair your adfsdf yourshasfsdfl,sdfsdei3 youyour ";
		String str = "your";
		int count = ssc.count(sourceStr, str);
		System.out.println(count);
		
	}
	
	public int count(String sourceStr, String str){
		sourceStr = sourceStr.toLowerCase();
		str = str.toLowerCase();
		int next = 0;
		int count = 0;
		int temp = 0;
		while((temp = sourceStr.indexOf(str, next)) != -1){
			count ++;
			next = temp + str.length();
		}
		return count;
	}
}
