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
	public UserInfo getObjectById(int  userId) {
		return userDao.getObjectById(userId);
	}
	@Transactional
	public List<UserInfo> getObjectlist() {
		return userDao.getObjectlist();
	}
	@Transactional
	public Serializable saveNewUser(UserInfo userinfo) {
		return userDao.saveNewObject(userinfo);
	}

	@Transactional
	public void saveUserRole(UserRole userrole) {
		urDao.saveNewObject(userrole);
	}
	
	@Transactional
	public String userExist(UserInfo user){
		long nums=(long)userDao.getHibernateTemplate().find("Select count(*) From UserInfo where userName = ?", new Object[]{user.getUserName()}).get(0);
		if(nums>0)
		{
			return    "昵称不可用!";
		}else{
			long nums1=(long)userDao.getHibernateTemplate().find("Select count(*) From UserInfo where telephone = ?", new Object[]{user.getTelephone()}).get(0);
			if(nums1>0)
			{
				return    "该手机号码已被注册!";
			}
			else{
				long nums2=(long)userDao.getHibernateTemplate().find("Select count(*) From UserInfo where mailAdd = ?", new Object[]{user.getMailAdd()}).get(0);
				if(nums2>0)
				{
					return    "该邮箱已被注册!";
				}
			}
		}
		return "OK";
	}
	
	
}
