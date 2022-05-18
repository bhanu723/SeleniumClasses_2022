package com.javasteams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SteamFilterExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> numList = Arrays.asList(1,5,6,1,4,5,6,7,8,9,9,90);
		
		List<String> nameList = Arrays.asList("Bhanu","Surendra","Deepala","Srikshitha","Sahasri");
		
		numList.stream().filter(n->n%2==0).forEach(System.out::println);
		List<Integer> oddList = numList.stream().filter(n->n%2==1).collect(Collectors.toList());
		
		System.out.println(oddList);

		nameList.stream().filter(s->!s.startsWith("S")).forEach(s->System.out.println(s+" "));
		nameList.stream().filter(s->s.length()>5).forEach(s->System.out.print(s+" "));
		
		List<String> strList_s = nameList.stream()
		.filter(s->s.startsWith("S") || s.length()>=5)
		.collect(Collectors.toList());
		
		
		/*
		 * numList.stream()
		 * .sorted().distinct().filter(n->n>6).forEach(System.out::println);
		 */
		List<Integer>  numList2 = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
		numList2.stream().filter(n->n%2==1).map(n->n*n).forEach(System.out::println);
		
	}

}

