package com.piao.jfp.c3.e10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.piao.jfp.utils.Utils;

public class E3102 {

	public static <T> Stream<T> Filter(Stream<T> stream, Predicate<T> predicate) {
		return stream.reduce((List<T>) new ArrayList<T>(), (x, y) -> {
			if (predicate.test(y)) {
				List<T> acc = new ArrayList<T>(x);
				acc.add(y);
				return acc;
			}
			return x;
		}, (x, y) -> {
			x.addAll(y);
			return x;
		}).stream();
	}

	public static void main(String[] args) {
		Utils.Println(Filter(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0), x -> x > 5).collect(Collectors.toList()));
		Utils.Println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).filter(x -> x > 5).collect(Collectors.toList()));
	}

}
