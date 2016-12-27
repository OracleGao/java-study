package org.pplm.jfp.dsl.bbd;

public class Description {
	public static void describe(String name, Suite behavior) {
		Description desc = new Description();
		System.out.print(name);
		behavior.specifySuite(desc);
	}
	
	public void should(String desc, Specification spec) {
		Expect expect = new Expect();
		System.out.print(desc);
		spec.specifyBehaviro(expect);
	}
	
}
