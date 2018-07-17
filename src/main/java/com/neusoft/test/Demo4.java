package com.neusoft.test;

public class Demo4 {

	public static void main(String[] args) {
		String str = "我是人CCCC";
		System.out.println(getLength(str));
	}
	
	public static int getLength(String str) {
		str = str.replaceAll("[^x00-xff]", "**");
		System.out.println(str);
		return str.length();
	}

}
