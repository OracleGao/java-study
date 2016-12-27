package org.pplm.jfp.c3.e9;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E397 {
	
	public static Optional<String> GetMostLowerString(List<String> strings) {
		return strings.stream().max((x, y) ->(int) (E396.lowerCount(x) - E396.lowerCount(y)));
	}
	
	public static void main(String[] args) {
		System.out.println(GetMostLowerString(Stream.of("aaaBBBCCC","abcde123", "opqrstuvwxyz").collect(Collectors.toList())).orElse("null"));
		System.out.println(GetMostLowerString(new ArrayList<>()).orElse("null"));
	}
	
}
