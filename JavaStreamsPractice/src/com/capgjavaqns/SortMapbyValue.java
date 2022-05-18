package com.capgjavaqns;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SortMapbyValue {

	public static void main(String[] args) {

		
		HashMap<String, Integer> map = new HashMap<>(); 
				map.put("Java",100);
				map.put("Python",40);
				map.put("C#",56);
		
		System.out.println("Sorted by Key");
		System.out.println("====================");
		map.entrySet().stream().sorted((o1,o2)->o1.getKey().compareTo(o2.getKey())).forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("Sorted by Value");
		System.out.println("====================");
		map.entrySet().stream().sorted((o1,o2)->o1.getValue()-o2.getValue()).forEach(System.out::println);
		
	}

}
