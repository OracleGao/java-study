package org.pplm.jfp.dsl.bbd;

public class Expect {
	public BoundExpectation that(Object value) {
		return new BoundExpectation(value);
	}
}
