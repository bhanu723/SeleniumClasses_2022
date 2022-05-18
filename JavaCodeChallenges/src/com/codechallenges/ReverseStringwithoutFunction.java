
/*
 **
 *@author : BhanuSurendra Deepala 
 *
 */
package com.codechallenges;

import java.util.stream.Stream;

public class ReverseStringwithoutFunction {

	public static void main(String[] args) {

		System.out.println(reverseString("Hello!"));
	}

	private static String reverseString(String inputStr) {

		StringBuilder outputStr = new StringBuilder();
		
		Stream.iterate(inputStr.length()-1, i->i-1).limit(inputStr.length()).forEach(i->outputStr.append(inputStr.charAt(i)));		
		
		return outputStr.toString();
	}

}
