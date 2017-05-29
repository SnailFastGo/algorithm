package com.coding.str;

/**String padString(String string,int minLength,char padChar)，就是在string前用padChar将string填充至minLength的长度，
 * 如("7",3,'0')得到的结果是"007"，("2012",3,'0')得到的结果是"2012"。minLength不能为负数。
 * @author snailfast
 *
 */
public class PadString {
	public static void main(String[] args) {
		PadString ps = new PadString();
		String padString = ps.padString("7",3,'0');
		System.out.println(padString);
		
	}
	
	public String padString(String source,int minLength,char padChar){
		if(source.length() >= minLength || minLength < 0){
			return source;
		}
		StringBuilder sb = new StringBuilder();
		int n = minLength - source.length();
		for(int i = 0; i < n; i ++){
			sb.append(padChar);
		}
		sb.append(source);
		return sb.toString();
	}
}
