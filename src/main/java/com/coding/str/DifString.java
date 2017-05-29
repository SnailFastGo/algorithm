package com.coding.str;

import java.util.ArrayList;
import java.util.List;

public class DifString {
	public static void main(String[] args) {
		DifString ds = new DifString();
		String dif = ds.dif("abcdefe", "aabcadef");
		System.out.println(dif);
	}
	
	public static String dif(String str1,String str2) {
		List<Character> set1 = new ArrayList<Character>();
		List<Character> set2 = new ArrayList<Character>();
		int n1 = str1.length();
		int n2 = str2.length();
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		String temp1 = str1;
		String temp2 = str2;
		for(int i = 0; i < n1; i ++){
			char c = str1.charAt(i);
			if(temp2.contains(c + "")){
				temp2 = temp2.replaceFirst(c + "", "");
			}else{
				set1.add(c);
			}
		}
		
		for(int i = 0; i < n2; i ++){
			char c = str2.charAt(i);
			if(temp1.contains(c + "")){
				temp1 = temp1.replaceFirst(c + "", "");
			}else{
				set2.add(c);
			}
		}
		String res = "";
		for(Character c : set1){
			res += "-" +  c.charValue() + ",";
		}
		for(Character c : set2){
			res += "+" +  c.charValue() + ",";
		}
		
		if("" == res){
			return res;
		}else{
			return res.substring(0,  res.length() - 1);
		}
	}
}
