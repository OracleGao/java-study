package org.pplm.study.jdp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
	
	public static Top proxy(Top top) {
		return (Top) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Top.class}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("proxy is called");
				Object obj =  method.invoke(top, args);
				System.out.println("proxy is called after proxied");
				return obj;
			}
		});
	}
	
	public static Top TopProxyAnnotation() {
		return (Top) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Top.class}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("proxy is called");
				Hello hello = Top.class.getMethod("helloWorld", new Class[]{String.class}).getAnnotation(Hello.class);
				System.out.println("annotaion message: " + hello.message());
				System.out.println("parameter: " + args[0].toString());
				System.out.println("proxy is called after proxied");
				return "1";
			}
		});
	} 
	
	public static void test() {
		Top top = DynamicProxy.proxy(new HelloWorld());
		System.out.println(top.helloWorld("oralce gao"));
		DynamicProxy.TopProxyAnnotation().helloWorld("2016-12-27");
		System.out.println();
	}
	
	public static void main(String[] args) {
		test();
	}
	
}
