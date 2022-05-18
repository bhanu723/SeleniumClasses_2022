/*
 * @Author : BhanuSurendra Deepala
 */
package com.codechallenges;

import java.util.TreeMap;

public class RepeatedCharWithourSort {

	public static void main(String[] args) {

		String inputStr = "googlingtonbhanusurendradeepala";
		/*
		 * Additional TestCases Verified
		 * =============================
		 * String inputStr = "bhanu"; 
		 * String inputStr =" googlingtonbhanusurendradeepala  "; 
		 * String inputStr = "   "; 
		 * String inputStr = ""; 
		 * String inputStr = null;
		 */		
		
		StringBuilder resultStr = new StringBuilder("");
		resultStr = displayRepeatedChar(inputStr);

		if (resultStr.length() == 0)
			System.out.println("No Repeated char or empty string or null");
		else
			System.out.println("\nResult String: "+resultStr);
	}

	// Method to return repeated characters from a string
	public static StringBuilder displayRepeatedChar(String str) {
		StringBuilder outputStr = new StringBuilder("");
		Integer count = 1;
		boolean repeatedCharFlag= false;
		
		// Create a TreeMap to capture each char as key and occurrences as value
		TreeMap<Character, Integer> charMap = new TreeMap<>();
		TreeMap<Character, StringBuilder> outputMap = new TreeMap<>();

		if (str != null) {
			char[] charArr = str.trim().toCharArray(); // convert string into array of char by removing leading or trailing spaces
			if (charArr.length != 0) {// condition to loop only when there is real string
				for (Character ch : charArr) {
					if (!charMap.containsKey(ch)) { // if char is not in the Map then add it with initial occurrence of
						charMap.put(ch, count);
						outputMap.put(ch, new StringBuilder(Character.toString(ch)));
					} else {
						repeatedCharFlag=true;
						charMap.put(ch, charMap.get(ch) + 1); // if the char is repeated then increment existing value
						outputMap.put(ch, outputMap.get(ch).append(ch));
					}
				}
			}
		}
		System.out.println(charMap); // Logging for better validation
		System.out.println(outputMap); // Logging for better validation
		
		if(repeatedCharFlag)
			outputStr = outputMap.values().stream().filter(s -> s.length() > 1).reduce((a,b)->a.append(b)).get();
		return outputStr;
	} // returns empty string if input is empty or no repeated char else returns repeated characters in alphabetical order
		
}
/* @Author : BhanuSurendra Deepala
 * 
 * Program Tested with edge cases covering below 6 TCs : 
 * TC01_Repeated & nonRepeated Char: "googlington" 
 * TC02_non Repeated Char: "abcedf" 
 * TC03_Repeated & non Repeated Char with leading or trailing spaces: "  googlingtonbhanu     "
 * TC04_No Char just spaces : "   " 
 * TC05_Empty String : "" 
 * TC06_null String: null
 */
