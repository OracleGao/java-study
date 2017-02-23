package org.pplm.study.shiro.authorization.test;

import java.util.Arrays;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;
import org.pplm.study.shiro.authorization.LoginUtils;

public class PermissionTest {
	
	@Test
	public void isPermittedTest() {
		Subject subject = LoginUtils.login("authorization/permission.ini", "piao", "passw0rd");
		Assert.assertEquals(true, subject.isPermitted("user:create"));
		Assert.assertEquals(true, subject.isPermitted("user:update"));
		Assert.assertEquals(true, subject.isPermittedAll("user:create", "user:update"));
		Assert.assertArrayEquals(new boolean[]{false, true, true}, subject.isPermitted("user:delete", "user:create", "user:update"));
		LoginUtils.logout(subject);
	}
	
	@Test(expected = UnauthorizedException.class)
	public void checkPermittedTest() {
		Subject subject = LoginUtils.login("authorization/permission.ini", "oracle", "passw0rd");
		subject.checkPermission("user:delete");
		subject.checkPermissions("user:delete", "user:create", "user:update");
		subject.checkPermissions("user:view");
		LoginUtils.logout(subject);
	}
}
