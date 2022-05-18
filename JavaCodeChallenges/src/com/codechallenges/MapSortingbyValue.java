/*
 **
 *@author : BhanuSurendra Deepala 
 *
 */

package com.codechallenges;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class MapSortingbyValue {

	public static void main(String[] args) {

		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("Bhanu",10);
		map.put("Surendra",0);
		map.put("Surekha",12);
		map.put("Srikshi",1);
		System.out.println(map);
		System.out.println(sortMapbyValues(map));
		
	}

	private static Map<String,Integer> sortMapbyValues(Map<String, Integer> map) {
		Map<String,Integer> outputMap=Map.of();
		Set<Entry<String, Integer>> s= map.entrySet();
		System.out.println(s);
		Iterator<Entry<String, Integer>> it = s.iterator();
		
		return outputMap;
	}

}
