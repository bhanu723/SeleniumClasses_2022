
/*
 **
 *@author : BhanuSurendra Deepala 
 *
 */
package com.codechallenges;

public class Factorical {

	public static void main(String[] args) {

		int n = 5;
		System.out.println(findFactorialRecursive(n));
		System.out.println(findFactorialNonRecursive(n));

	}

	private static int findFactorialNonRecursive(int n) {
		int result=n;
		
		while(n>1) {
			result=result*(n-1);
			n--;
		}
		return result;
	}

	private static int findFactorialRecursive(int n) {

		if (n <= 1)
			return 1;
		else
			return n * findFactorialRecursive(n - 1);

	}

}
