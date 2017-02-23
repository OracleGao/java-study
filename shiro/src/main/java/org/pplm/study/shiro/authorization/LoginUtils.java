package org.pplm.study.shiro.authorization;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class LoginUtils {
	
	public static Subject login(String iniFile, String username, String password) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:" + iniFile);
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken authenticationToken = new UsernamePasswordToken(username, password);
		try {
			subject.login(authenticationToken);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		return subject;
	}
	
	public static void logout(Subject subject) {
		subject.logout();
	}
	
}
