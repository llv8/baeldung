package com.baeldung.firstoccurrenceofaninteger;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


class FirstOccurrenceOfAnIntegerTests {

	@Test
	public void whenUsingPatternMatcher_findFirstInteger() {
		String s = "ba31dung123";
		Matcher matcher = Pattern.compile("\\d+").matcher(s);
		matcher.find();
		int i = Integer.parseInt(matcher.group());
		Assertions.assertEquals(31, i);
	}

	@Test
	public void whenUsingScanner_findFirstInteger() {
		int i = new Scanner("ba31dung123").useDelimiter("\\D+").nextInt();
		Assertions.assertEquals(31, i);
	}

	@Test
	public void whenUsingSplit_findFirstInteger() {
		String str = "ba31dung123";
		List<String> tokens = Arrays.stream(str.split("\\D+"))
				.filter(s -> s.length() > 0).collect(Collectors.toList());
		Assertions.assertEquals(31, Integer.parseInt(tokens.get(0)));
	}

	@Test
	public void whenUsingCustomFunction_findFirstInteger() {
		String str = "ba31dung123";
		Integer i = FirstOccurrenceOfAnInteger.findFirstInteger(str);
		Assertions.assertEquals(31, i);
	}


}
