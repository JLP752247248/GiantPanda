package com.panda.sys.security;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.panda.sys.dao.UserInfoDao;
import com.panda.sys.po.UserInfo;

@Component("userDetailsService")
public class DaoUserDetailsService implements UserDetailsService,
        AuthenticationUserDetailsService {
	@Resource
	private UserInfoDao userInfoDao;
	
	public UserDetails loadUserDetails(Authentication arg0)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		
		UserInfo user=userInfoDao.listObjectsByHql("from UserInfo where userName = ?", new String[]{userName}).get(0);
		return new UserDetailsImpl(user);
		
	}
}
