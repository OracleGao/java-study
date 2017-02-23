package org.pplm.study.shiro.authorization;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoleFunction {
	
	private static Logger logger = LoggerFactory.getLogger(RoleFunction.class);
	
	@RequiresRoles("role1")
	public void role1Func() {
		logger.info("role1 called");
	}
	
	@RequiresRoles("role2")
	public void role2Func() {
		logger.info("role2 called");
	}
	
	@RequiresRoles("*")
	public void rolesRunc() {
		logger.info("role * called");
	}
	
}
