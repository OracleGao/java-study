package org.pplm.study.cglib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.pplm.study.cglib.DynamicProxy.LazyBean.PropertyBean;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Dispatcher;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.InterfaceMaker;
import net.sf.cglib.proxy.LazyLoader;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;

public class DynamicProxy {
	
	public static class TargetInterceptor implements MethodInterceptor {
		/**
		 * Method is the proxyied method
		 */
		@Override
		public Object intercept(Object object, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
			System.out.println("before call " + method.getName());
			//Object obj = method.invoke(object, params);//unlimit recursion
			Object obj = methodProxy.invokeSuper(object, params);
			System.out.println("after call " + method.getName());
			return obj;
		}
	}
	
	public static class TargetResultFixed implements FixedValue {
		@Override
		public Object loadObject() throws Exception {
			Object obj = new Integer(999);
			return obj.toString();
		}
	}
	
	public static class TargetMethodCallbackFilter implements CallbackFilter {

		@Override
		public int accept(Method method) {
			String name = method.getName();
			System.out.println("filter method name: " + name);
			if(method.getName().equals("showMessage")){  
	            System.out.println("filter showMessage == 0");  //showMessage method match callback array index 0
	            return 0;  
	        }  
			
			if(method.getName().equals("getMessage")){  
	            System.out.println("filter getMessage == 2");  //getMessage method match callback array index 2
	            return 2;
	        } 
			
			if(method.getName().equals("setMessage")){  
	            System.out.println("filter setMessage == 1");  //setMessage method match callback array index 1
	            return 1;
	        }  
			return 0;
		}
	}

	public static interface HelloInterface {
		public String helloworld(String mess);
	}
	
	public static void testCallbackAndFilter() {
		Enhancer enhancer = new Enhancer();  
		enhancer.setSuperclass(HelloWorld.class);  
		enhancer.setCallbacks(new Callback[]{new TargetInterceptor(), NoOp.INSTANCE, new TargetResultFixed()});
		enhancer.setCallbackFilter(new TargetMethodCallbackFilter());
		HelloWorld helloWorld = (HelloWorld) enhancer.create();
		helloWorld.showMessage();
		helloWorld.setMessage("hello world");
		System.out.println(helloWorld.getMessage());
	}
	
	public static void testInterface() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		InterfaceMaker interfaceMaker = new InterfaceMaker();
		interfaceMaker.add(HelloInterface.class);
		Class<?> targetInterfact = interfaceMaker.create();
		Object obj = Enhancer.create(HelloInterface.class, new Class[] {targetInterfact}, new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
				System.out.println("method name: " + method.getName());
				methodProxy.invokeSuper(obj, new Object[]{"11111"});// no such method 
				return "helloworld!!";
			}
		});
		System.out.println(obj.getClass().getMethod("helloworld", new Class[]{String.class}).invoke(obj, "1234556"));
		System.out.println();
		System.out.println();
	}
	
	public static class LazyBean {
		
		private String name;
		private int age;
		
		private PropertyBean propertyBean = (PropertyBean) Enhancer.create(PropertyBean.class, new LazyLoader() {
			@Override
			public Object loadObject() throws Exception {
				System.out.println("before lazyLoader...");  
		        PropertyBean propertyBean = new PropertyBean();  
		        propertyBean.setKey("zghw");  
		        propertyBean.setValue(new Object());  
		        System.out.println("after lazyLoader...");  
		        return propertyBean;  
			}
		});
		
		private PropertyBean propertyBeanDispatcher = (PropertyBean) Enhancer.create(PropertyBean.class, new Dispatcher(){
			@Override
			public Object loadObject() throws Exception {
				System.out.println("before Dispatcher...");  
		        PropertyBean propertyBean = new PropertyBean();  
		        propertyBean.setKey("xxx");  
		        propertyBean.setValue(new Object());  
		        System.out.println("after Dispatcher...");  
		        return propertyBean;  
			}
		});

		public LazyBean() {
			super();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public PropertyBean getPropertyBean() {
			return propertyBean;
		}

		public void setPropertyBean(PropertyBean propertyBean) {
			this.propertyBean = propertyBean;
		}

		public PropertyBean getPropertyBeanDispatcher() {
			return propertyBeanDispatcher;
		}

		public void setPropertyBeanDispatcher(PropertyBean propertyBeanDispatcher) {
			this.propertyBeanDispatcher = propertyBeanDispatcher;
		}
		
		public static class PropertyBean {
			private String key;
			private Object value;
			
			public PropertyBean() {
				super();
			}

			public String getKey() {
				return key;
			}

			public void setKey(String key) {
				this.key = key;
			}

			public Object getValue() {
				return value;
			}

			public void setValue(Object value) {
				this.value = value;
			}
			
		}
	}
	

	public static void testLazyBean() {
		LazyBean lazyBean = new LazyBean();
		lazyBean.setName("oralce");
		PropertyBean propertyBean = lazyBean.getPropertyBean();
		propertyBean.getKey();
		propertyBean.getValue();
		propertyBean.getValue();
		propertyBean = lazyBean.getPropertyBeanDispatcher();
		propertyBean.getValue();
		propertyBean.getKey();
		propertyBean.getValue();
	}
	
	public static void main(String[] args) throws Exception {
		testLazyBean();
	}
	
}
