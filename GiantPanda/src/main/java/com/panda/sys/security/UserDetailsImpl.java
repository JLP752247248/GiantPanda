package com.panda.sys.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import com.panda.sys.po.UserInfo;

public class UserDetailsImpl implements UserDetails{

	/**
	 * 
	 */
	String userName;
	String password;
	Collection <GrantedAuthorityImpl> authorities=null;
	private static final long serialVersionUID = 1L;

	public UserDetailsImpl(String userName,String password){
		this.userName=userName;
		this.password=password;
	}
	public UserDetailsImpl(UserInfo user) {
		this.userName=user.getUserName();
		this.password=user.getPassword();
		this.authorities=new ArrayList();
		this.authorities.add(new GrantedAuthorityImpl("User"));
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		return this.authorities;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
