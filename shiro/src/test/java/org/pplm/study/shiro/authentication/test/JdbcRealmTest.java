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

/**
 * 
 * SecurityManager is a VM static variable, binding a thread.
 * @author OracleGao
 *
 */
public class JdbcRealmTest {
	
	@Test
	public void jdbcRealmTest() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:authentication/jdbcRealm.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken authenticationToken = new UsernamePasswordToken("admin", "123456");
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
