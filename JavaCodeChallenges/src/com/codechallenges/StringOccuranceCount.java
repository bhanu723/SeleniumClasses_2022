
/*
 **
 *@author : BhanuSurendra Deepala 
 *
 */
package com.codechallenges;

import java.util.HashMap;
import java.util.Map;

public class StringOccuranceCount {

	/**
	 * This method is to count the no of occurrences of a word in a sentence
	 * 
	 * @Author - BhanuSurendra Deepala
	 * @param  - Method takes String input
	 * @return - This method returns an output Map<String, Integer> with word as key
	 * and it's occurrences as value from the given String
	 **/

	public Map<String, Integer> countStringOccurances(String inputStr) {

		Map<String, Integer> outputMap = new HashMap<>();

		try {
			if (!(inputStr.length() == 0) && !(inputStr == null)) {
				String[] strArr = inputStr.split(" ");
				Integer count = 1;

				for (String word : strArr) {
					if (!outputMap.containsKey(word)) {
						outputMap.put(word, count);
					} else
						outputMap.put(word, outputMap.get(word) + 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outputMap;
	}

}
