package org.pplm.jfp.dsl.bbd;

import static org.pplm.jfp.dsl.bbd.Description.*;

import java.util.Stack;

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
