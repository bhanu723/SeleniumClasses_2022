package com.javasteams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumofSqofOddNums {

	public int sumofSqofOddNo(List<Integer> l) {
		int sum = 0;
		List<Integer> oddList = new ArrayList<>();

		/*
		 * oddList = l.stream().filter(n -> n % 2 == 1).map(n -> n *
		 * n).collect(Collectors.toList()); for (int n : oddList) sum += n;
		 */
		sum = l.stream().filter(n->n%2==1).map(n->n*n).reduce(0,(x,y)->x+y);

		return sum;

	}

	public static void main(String[] args) {

		
		List<Integer> l = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		double[] numbers = {1,3,4,5,1,7,9};
		Arrays.stream(numbers).filter(n->n%2==1).map(n->Math.log(n)).boxed().forEach(System.out::println);;
		
		SumofSqofOddNums s = new SumofSqofOddNums();
		System.out.println(s.sumofSqofOddNo(l));
		
		System.out.println(IntStream.range(1, 20).filter(n->n%2==1).map(n->n*n).reduce(0,(x,y)->x+y));
	}

}
