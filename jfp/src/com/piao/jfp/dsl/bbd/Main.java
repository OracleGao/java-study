package com.piao.jfp.dsl.bbd;

import java.util.Stack;

import static com.piao.jfp.dsl.bbd.Description.*;

public class Main {
	
	{
		describe("a stack ", it -> {
			it.should("push new elements onto the top of the stack", expect -> {
				Stack<Integer> stack = new Stack<>();
				stack.push(1);
				expect.that(stack.pop()).isEqualTo(2);
			});
		});
	}
/**
 * 开启java断言：jre配置界面的Default vm arguments中加入 -ea
 */
	public static void main(String[] args) {
		new Main();
	}
}
