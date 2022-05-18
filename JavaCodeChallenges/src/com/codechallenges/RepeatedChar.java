package com.codechallenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RepeatedChar {

	public static void main(String[] args) {

		String inputStr = " googlington  ";
		String outputStr = "";
		outputStr = displayRepeatedChar(inputStr);

		if (outputStr.length() == 0)
			System.out.println("No Repeated char or empty string or null");
		else
			System.out.println(outputStr);
	}

	// Method to return repeated characters from a string
	public static String displayRepeatedChar(String str) {
		String outputStr = "";
		Integer count = 1;
		if (str != null) {
			char[] charArr = str.trim().toCharArray(); // convert string into array of char by removing leading or trailing spaces
			Arrays.sort(charArr);

			// Create a HashMap to capture each char as key and occurrences as value
			Map<Character, Integer> charMap = new HashMap<>();
//			TreeMap<Character,Integer> charMap = new TreeMap<>();
			
			if (charArr.length != 0) {// condition to loop only when there is real string
				for (Character ch : charArr) {
					if (!charMap.containsKey(ch)) { //if char is not in the Map then add it with initial occurrence of 1
						charMap.put(ch, count);
					} else {
						charMap.put(ch, charMap.get(ch) + 1); // if the char is repeated then increment existing value associated with char key
						if (charMap.get(ch) == 2)
							outputStr = outputStr + ch + ch;
						// Append char twice when char occurrence is 2 else once
						else
							outputStr += ch;
					}
				}
			}
		}
		return outputStr;
	}	// returns empty string if input is empty or no repeated char else returns
		// repeated characters in alphabetical order
	
}
/*
 * @Author : BhanuSurendra Deepala
 *
 * Program Tested with edge cases covering below 6 TCs :
 * TC01_Repeated & non Repeated Char: "googlington"
 * TC02_non Repeated Char: "abcedf"
 * TC03_Repeated & non Repeated Char with leading or trailing spaces: "  googlingtonbhanu     "
 * TC04_No Char just spaces : "   "
 * TC05_Empty String : ""
 * TC06_null String: null
 */
