package org.pplm.jfp.dsl.bbd;

public class BoundExpectation {
	private Object value;
	
	public BoundExpectation(Object value) {
		this.value = value;
	}
	
	public void isEqualTo(int value) {
		assert this.value.equals(value): "not equal";
	}
}
