package com.capgjavaqns;

public class StringMain {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		
		System.out.println(str1==str2); //compares same memory location as both references are pointing to String Constant Pool(SCP)
		System.out.println(str1==str3); //compares string pool with Object ref from Heap
		
		System.out.println(str1.equals(str3)); // compares values
		
		String str4 = "AbC"; // equalsIgnoreCase() method can be used to compare values ignoring case
		
		System.out.println(str1.equalsIgnoreCase(str4));
		
	}

}
