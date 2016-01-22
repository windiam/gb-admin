package com.genebook.admin.utils;

import java.io.Serializable;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pricipalCollection) {
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		return simpleAuthorInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
	
		String inputUsername = token.getUsername();
		String inputPwd = String.valueOf(token.getPassword());
		
		ShiroUser shiroUser = new ShiroUser(1L, "admin");
		AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(shiroUser, inputPwd, inputUsername);
		return authcInfo;
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Long id;
		private String username;
		
		public ShiroUser() {
			super();
		}
		
		public ShiroUser(Long id, String username) {
			super();
			this.id = id;
			this.username = username;
		}
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
	}
}
