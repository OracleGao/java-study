package org.pplm.study.shiro.authorization.test;

import java.util.Arrays;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;
import org.pplm.study.shiro.authorization.LoginUtils;



public class RoleTest {

	@Test
	public void hasRoleTest() {
		Subject subject = LoginUtils.login("authorization/role.ini", "oracle", "passw0rd");
		Assert.assertEquals(true, subject.hasRole("role1"));
		Assert.assertEquals(true, subject.hasRole("role2"));
		Assert.assertEquals(true, subject.hasAllRoles(Arrays.asList("role1", "role2")));
		Assert.assertArrayEquals(new boolean[]{true,  true, false}, subject.hasRoles(Arrays.asList("role1", "role2", "role3")));
		LoginUtils.logout(subject);
	}
	
	@Test(expected = UnauthorizedException.class)
	public void checkRoleTest() {
		Subject subject = LoginUtils.login("authorization/role.ini", "piao", "passw0rd");
		subject.checkRole("role1");
		subject.checkRoles("role1", "role2");
		LoginUtils.logout(subject);
	} 
}
