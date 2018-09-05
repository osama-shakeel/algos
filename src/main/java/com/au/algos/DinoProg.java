package com.au.algos;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DinoProg {

	private static class Dino {
		String name;
		BigDecimal legLength;
		BigDecimal strideLength;
		String diet;
		String stance;
	}
	
	private void test() {
		ExecutorService ex = null;
		ex.submit(() -> {System.out.println("Hello");});
	}
	
	public static void main(String[] args) {
//		List<List<String>> namesNested = Arrays.asList( 
//			      Arrays.asList("Jeff", "Bezos"), 
//			      Arrays.asList("Bill", "Gates"), 
//			      Arrays.asList("Mark", "Zuckerberg"));
//		List<String> namesFlatStream = namesNested.stream()
//			      .flatMap(list -> list.stream())
//			      .sorted()
//			      .collect(Collectors.toList());
//		namesFlatStream.forEach(name -> System.out.println(name));
		Stream <String> s = Stream.of("H");
		System.out.println(s.count()+s.count());
	}
}
