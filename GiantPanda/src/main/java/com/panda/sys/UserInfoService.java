package com.panda.sys;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.panda.base.util.MyLogUtil;
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
	@Transactional
	public UserInfo getObjectById(String userId) {
		return userDao.getObjectById(userId);
	}
	@Transactional
	public List<UserInfo> getObjectlist() {
		return userDao.getObjectlist();
	}
	@Transactional
	public Serializable saveNewUser(UserInfo userinfo) {
		MyLogUtil.writeToFile("service");
	//	userDao.saveNewObject(userinfo);
		return userDao.saveNewObject(userinfo);
	}

	@Transactional
	public void saveUserRole(UserRole userrole) {
		urDao.saveNewObject(userrole);
	}

	
	
}
