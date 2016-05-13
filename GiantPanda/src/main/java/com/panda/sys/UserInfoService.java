package com.panda.sys;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.panda.sys.dao.UserInfoDao;
import com.panda.sys.dao.UserRoleDao;
import com.panda.sys.po.UserInfo;
import com.panda.sys.po.UserRole;

@Service
public class UserInfoService {

	@Resource
	UserInfoDao userDao;
	@Resource
	UserRoleDao urDao;
	
	public UserInfo getObjectById(String userId) {
		return userDao.getObjectById(userId);
	}

	public List<UserInfo> getObjectlist() {
		return userDao.getObjectlist();
	}

	public Serializable saveNewUser(UserInfo userinfo) {
		return userDao.saveNewObject(userinfo);
	}

	public void saveUserRole(UserRole userrole) {
		urDao.saveNewObject(userrole);
	}

	
	
}
