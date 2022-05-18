package com.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.codechallenges.StringOccuranceCount;

public class StringOccuranceCountTestCases extends StringOccuranceCount {

	StringOccuranceCount stroccurobj = new StringOccuranceCount();

	@Test
	public void tc01_ValidStringwithRepeatedwordsTest() {
		Map<String, Integer> actual_outputMap = stroccurobj
				.countStringOccurances("I am learning java and java is oop learning java is great and awesome");
		Map<String, Integer> expected_output = Map.of("oop", 1, "awesome", 1, "java", 3, "and", 2, "I", 1, "learning",
				2, "is", 2, "am", 1, "great", 1);
		Assert.assertEquals(actual_outputMap, expected_output);
	}
	
	@Test
	public void tc02_ValidStringbutNoRepeatedwordsTest() {
		Map<String, Integer> actual_outputMap = stroccurobj
				.countStringOccurances("I am learning java");
		Map<String, Integer> expected_output = Map.of("java", 1,"I", 1, "learning",1,"am", 1);
		Assert.assertEquals(actual_outputMap, expected_output);
	}
	
	@Test
	public void tc03_EmptyStringTest() {
		Map<String, Integer> actual_outputMap = stroccurobj
				.countStringOccurances("");
		Map<String, Integer> expected_output = Map.of();
		Assert.assertEquals(actual_outputMap, expected_output);
	}

	@Test
	public void tc04_StringWithSpacesTest() {
		Map<String, Integer> actual_outputMap = stroccurobj
				.countStringOccurances("   ");
		Map<String, Integer> expected_output = Map.of();
		Assert.assertEquals(actual_outputMap, expected_output);

	}
	
	@Test
	public void tc05_StringWithnullTest() {

		Map<String, Integer> actual_outputMap = stroccurobj
				.countStringOccurances(null);
		Map<String, Integer> expected_output = Map.of();
		Assert.assertEquals(actual_outputMap, expected_output);
	}
	
	@Test
	public void tc06_ValidStringwithAllRepeatedwordsTest() {

		Map<String, Integer> actual_outputMap = stroccurobj
				.countStringOccurances("I am learning java and java is oop learning java is great and awesome oop awesome I am great");

		Map<String, Integer> expected_output = Map.of("awesome", 2, "java", 3, "and", 2, "I", 2, "learning",
				2, "is", 2, "am", 2, "great", 2,"oop", 2);

		Assert.assertEquals(actual_outputMap, expected_output);

	}

}
