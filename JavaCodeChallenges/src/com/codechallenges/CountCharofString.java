package com.codechallenges;

public class CountCharofString {

	public int countcharofaString(String inputStr) {
		int l = 0;
		if (!(inputStr == null)) {
			l = inputStr.replaceAll(" ", "").length();
			System.out.println(inputStr.replaceAll(" ", ""));
		}

		return l;
	}

	public static void main(String[] args) {
		CountCharofString count = new CountCharofString();

		System.out.println(count.countcharofaString(null));
	}
}
