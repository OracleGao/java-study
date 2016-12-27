package org.pplm.study.classloader;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.http.client.ClientProtocolException;
import org.pplm.study.classloader.utils.HttpClientUtils;

public class NetworkClassLoader extends ClassLoader {
	private String urlPrefix;
	
	public NetworkClassLoader(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}
	
	public Class<?> loadClassByUri(String uri) throws ClientProtocolException, IOException {
		byte[] bytes = HttpClientUtils.onGetBytes(urlPrefix + uri);
		return super.defineClass(null, bytes, 0, bytes.length);
		
	}
	
	public static void test() throws Exception {
		NetworkClassLoader networkClassLoader = new NetworkClassLoader("http://10.1.10.20/package");
		Class<?> clazz = networkClassLoader.loadClassByUri("/HelloWorld.class");
		Object object = clazz.newInstance();
		System.out.println(object.toString());
//		System.out.println(((HelloWorld) object).getMessage()); thorw java.lang.ClassCastException, local helloworld class is diff with remote one
		clazz = networkClassLoader.loadClassByUri("/ConfigPlayer$KeyFormatSupport.class");
		clazz = networkClassLoader.loadClassByUri("/ConfigPlayer.class");
		Method method = clazz.getMethod("getInstance", new Class<?>[0]);
		object = method.invoke(null, new Object[0]);
		method = clazz.getMethod("getString", new Class<?>[]{ String.class });
		String userDir = (String) method.invoke(null, new Object[]{"user.dir"});
		System.out.println(userDir);
	}
	
	public static void testInterface() throws Exception {
		NetworkClassLoader networkClassLoader = new NetworkClassLoader("http://10.1.10.20/package");
		Class<?> clazz = networkClassLoader.loadClassByUri("/InterfaceTestImpl.class");
		
		Object object = clazz.newInstance();
		clazz = new NetworkClassLoader("http://10.1.10.20/package").loadClassByUri("/InterfaceTest.class");
		//clazz.cast(object); // throw  java.lang.ClassCastException: Cannot cast org.pplm.study.classloader.InterfaceTestImpl to org.pplm.study.classloader.InterfaceTest
		InterfaceTest it = (InterfaceTest) object;
		it.helloworld();
	}
	
	public static void main(String[] args) throws Exception {
		test();
		testInterface();
	}
}
