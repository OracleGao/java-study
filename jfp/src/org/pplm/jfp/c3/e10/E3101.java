package com.piao.jfp.c3.e10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.piao.jfp.utils.Utils;

public class E3101 {
	public static <T, R> Stream<R> Map(Stream<T> stream, Function<T, R> function) {
		return stream.reduce((List<R>) new ArrayList<R>(), (BiFunction<List<R>, T, List<R>>) (x, y) -> {
			List<R> acc =new ArrayList<>(x);
			acc.add(function.apply(y));
			return acc;
		}, (BinaryOperator<List<R>>) (x, y) -> {
			x.addAll(y);
			return x;
		}).stream();
	}

	public static <T, R> Stream<R> Map1(Stream<T> stream, Function<T, R> function) {
		return stream.reduce((List<R>) new ArrayList<R>(), (x, y) -> {
			List<R> acc =new ArrayList<>(x);
			acc.add(function.apply(y));
			return acc;
		}, (x, y) -> {
			x.addAll(y);
			return x;
		}).stream();
	}

	public static void main(String[] args) {
		Utils.Println(Map(Stream.of("aa", "bb", "ccc", "dddd"), x -> x.length()).collect(Collectors.toList()));
		Utils.Println(Map1(Stream.of("aa", "bb", "ccc", "dddd"), x -> x.length()).collect(Collectors.toList()));
		Utils.Println(Stream.of("aa", "bb", "ccc", "dddd").map(x -> x.length()).collect(Collectors.toList()));
	}
}
