
/*
 **
 *@author : BhanuSurendra Deepala 
 *
 */
package com.codechallenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Stream;

public class RepeatedCharTreeMap {

	public static void main(String[] args) {

		String inputStr = " googlingtonbhanusurendradeepala  ";
		StringBuilder outputStr = new StringBuilder("");
		outputStr = displayRepeatedChar(inputStr);

		if (outputStr.length() == 0)
			System.out.println("No Repeated char or empty string or null");
		else
			System.out.println(outputStr);
	}

	public static StringBuilder displayRepeatedChar(String str) {
		TreeMap<Character, StringBuilder> outputMap = new TreeMap<>();
		if (str != null) {
			char[] charArr = str.trim().toCharArray(); // convert string into array of char by removing leading or
														// trailing spaces
			if (charArr.length != 0) {// condition to loop only when there is real string
				for (Character ch : charArr) {
					outputMap.put(ch, outputMap.getOrDefault(ch, new StringBuilder()).append(ch));
				}
			}
		}
		Optional<StringBuilder> reduce = outputMap.values().stream().filter(s -> s.length() > 1)
				.reduce((a, b) -> a.append(b));
		StringBuilder outputStr = new StringBuilder();
		if (reduce.isPresent()) {
			outputStr = reduce.get();
		}
//		System.out.println(outputStr);
		return outputStr;
	}
}
/*
 * @Author : BhanuSurendra Deepala
 *
 * Program Tested with edge cases covering below 6 TCs : TC01_Repeated & non
 * Repeated Char: "googlington" TC02_non Repeated Char: "abcedf" TC03_Repeated &
 * non Repeated Char with leading or trailing spaces: "  googlingtonbhanu     "
 * TC04_No Char just spaces : "   " TC05_Empty String : "" TC06_null String:
 * null
 */
