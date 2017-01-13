package org.pplm.study.shiro.authentication;

import java.util.Arrays;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm1 implements Realm {

	@Override
	public String getName() {
		return "myrealm1";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		return token != null && token.getClass().isAssignableFrom(UsernamePasswordToken.class);
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		Object principal = token.getPrincipal();
		Object credentials = token.getCredentials();
		if (!"helloworld".equals(principal)) {
			throw new UnknownAccountException();// invalidate username
		}
		if (!Arrays.equals("passw0rd".toCharArray(), (char[]) credentials)) {
			throw new IncorrectCredentialsException(); // invalidate password
		}
		return new SimpleAuthenticationInfo(principal, credentials, this.getName());
	}

}
