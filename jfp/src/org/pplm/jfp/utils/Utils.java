package org.pplm.jfp.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {
    //https://github.com/RichardWarburton
	
	public static void Println(List<?> strs) {
		System.out.println(toString(strs));
	}

	public static String toString(List<?> objs) {
		if (objs == null) {
			return "[]";
		}
		return toString(objs.stream());
	}

	public static String toString(Stream<?> stream) {
		return stream.map(Object::toString).collect(Collectors.joining(",", "[", "]"));
	}
	
	public static void main(String[] args) {
		Println(Stream.of("aaa", "bbb", "ccc").collect(Collectors.toList()));
	}

}
