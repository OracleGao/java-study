package com.piao.jfp.c6.e9;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E691 {
	
	public static int sequentialSumOfSquares(IntStream range) {
		return range.map(x -> x * x).sum();
	}
	
	public static int SequentialSumOfSquares(IntStream range) {
		return range.parallel().map(x -> x * x).sum();
	}
	
	public static int SequentialSumOfSquares1(IntStream range) {
		return range.parallel().reduce(0, (x, y) -> x + y * y);
	}
	
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		Random random = new Random(System.currentTimeMillis());
		List<Integer> list = random.ints(9000000, 0, 10000).mapToObj(Integer::valueOf).collect(Collectors.toList());
		IntStream range = list.stream().mapToInt(Integer::intValue);
		System.out.println("begin");
		long time = System.currentTimeMillis();
		sequentialSumOfSquares(range);
		System.out.println(System.currentTimeMillis() - time);
		range = list.stream().mapToInt(Integer::intValue);
		time = System.currentTimeMillis();
		SequentialSumOfSquares(range);
		System.out.println(System.currentTimeMillis() - time);
		range = list.stream().mapToInt(Integer::intValue);
		time = System.currentTimeMillis();
		SequentialSumOfSquares1(range);
		System.out.println(System.currentTimeMillis() - time);
	}
	
}
