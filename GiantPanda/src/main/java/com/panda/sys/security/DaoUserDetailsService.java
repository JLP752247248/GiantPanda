package com.panda.sys.security;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.panda.sys.dao.UserInfoDao;
import com.panda.sys.po.UserInfo;



@Service("userDetailsService")
public class DaoUserDetailsService implements UserDetailsService,
        AuthenticationUserDetailsService {
	@Resource
	private UserInfoDao userInfoDao;
	
	public UserDetails loadUserDetails(Authentication arg0)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    @Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String loginName)
			throws UsernameNotFoundException {
		List<UserInfo> list=userInfoDao.listObjectsByHql("from UserInfo where userName = ? or telephone=? or mailAdd=?", new Object[]{loginName,loginName,loginName});
		if(null==list || list.size()==0){
			throw new RuntimeException("您输入的用户"+loginName+"不存在！");
		}
		else {
		UserInfo user=list.get(0);
		return new UserDetailsImpl(user);
		}
	}
}
