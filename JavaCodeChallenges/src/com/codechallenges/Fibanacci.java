
/*
 **
 *@author : BhanuSurendra Deepala 
 *
 */
package com.codechallenges;

public class Fibanacci {

	public static void main(String[] args) {
//		long startTime = System.currentTimeMillis();
		int n = 10;
		System.out.println(n + "th fibanacci number: " + findFibanacciRecursive(n));
//		long totalTime = System.currentTimeMillis()-startTime;
//		System.out.println("Total time taken: "+totalTime);
		System.out.println();
		System.out.println(n + "th fibanacci number_Recursive Method: " + findFibanacciNonRecursive(n));
		System.out.println();
		System.out.println(n + "th fibanacci number: " + findFibanacciDynamicProgramming(n));
	}

	// Non Recursive Method : O(n)
	private static long findFibanacciNonRecursive(int n) {
		long f1 = 0;
		long f2 = 1;
		long result = 0;

		System.out.println("Non Recursive method Fibanacci series upto " + n);

		if (n <= 1)
			return n;

		while (n > 1) {
			result = f1 + f2;
			f1 = f2;
			f2 = result;
			System.out.println(result);
			n--;
		}
		return result;
	}

	// Method 2: Recursive :O(2^n)
	private static long findFibanacciRecursive(int n) {

		// base condition
		if (n <= 1)
			return n;

		return findFibanacciRecursive(n - 1) + findFibanacciRecursive(n - 2);
	}

	// Method 3- Dynamic Programming avoiding recalculation_store the value : O(n)
	private static long findFibanacciDynamicProgramming(int n) {

		int[] f = new int[n + 2]; // array to store fib numbers and define size as +2 to handle when n is 0 or 1

		f[0] = 0;
		f[1] = 1;

		System.out.println("Dynamic Programming Fibanacci series upto " + n);
		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
			System.out.println(f[i]);
		}

		return f[n];

	}

}
