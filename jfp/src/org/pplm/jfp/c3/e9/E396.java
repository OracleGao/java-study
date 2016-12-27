package com.piao.jfp.c3.e9;

public class E396 {
	public static long lowerCount(String string) {
		return string.chars().filter(c -> Character.isLowerCase(c)).count();
	}
	
	public static void main(String[] args) {
		System.out.println(lowerCount("abcdefg1234567890ABCDEFG!@#$%^&*()"));
	}
	
}
