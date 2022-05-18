package com.codechallenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {

		String inputStr = "Sur endr aSu r ekha";
//		System.out.println(inputStr.replaceAll(" ", ""));
		System.out.println("First Non Repeating Char from a string excluding spaces");
		System.out.println(findFirstNonRepeatingChar(inputStr ));
	}

	private static Character findFirstNonRepeatingChar(String inputStr) {
		Character ch;
		
		Map<Character,Integer> map = new HashMap<>();
		
		char[] chArr = inputStr.replaceAll(" ","").toCharArray();
		for(char c: chArr) {
			if(!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c)+1);
		}

		map.entrySet().forEach(System.out::println);
//		Entry<Character, Integer> e = map.entrySet().stream().filter(x->x.getValue()==1).findFirst().get();
//		return e.getKey();
		
		return map.entrySet().stream().filter(x->x.getValue()==1).findFirst().get().getKey();
	}

}
