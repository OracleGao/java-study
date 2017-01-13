package org.pplm.study.shiro.authentication.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class MyRealmTest {
	
	@Test
	public void myRealmTest() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:myRealm.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken authenticationToken = new UsernamePasswordToken("helloworld", "passw0rd");
		try {
			subject.login(authenticationToken);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		Assert.assertEquals("login failed", subject.isAuthenticated(), true);
		subject.logout();
		Assert.assertEquals("logout failed", subject.isAuthenticated(), false);
	}

}