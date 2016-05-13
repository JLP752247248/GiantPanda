package com.panda.sys.po;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
@Entity
@Table(name="SYS_USERROLE")
public class UserRole {

	@Id
	@Column(name="USERROLEID")
	/*@GenericGenerator(name="hibernate-uuid", strategy="uuid")  
    @GeneratedValue(generator="hibernate-uuid")*/  
	private String userRoleId;
	@ManyToOne(cascade={CascadeType.MERGE})/*这里的merge，persist等和dao里面用的是对应的，
	如果dao里面用save或者update等不标准的方法，这里级联将不起作用，但是当设置为all的时候却又都起作用。
	For the save() operation to be cascaded, 
	you need to enable CascadeType.SAVE_UPDATE, 
	using the proprietary Hibernate Cascade annotation, 
	since save() is not a standard JPA operation. 
	Or you need to use the persist() method, and not the save() method.*/
	@JoinColumn(name="userId")
	@JSONField(serialize=false)
	private UserInfo userInfo;
	
	@ManyToOne
	@JoinColumn(name="roleId")
	@JSONField(serialize=false)
	private RoleInfo roleInfo;
	
	@Column(name="TEST")
	private String test;
	
	
	public UserRole() {
	}
	public UserRole(String urid, UserInfo user,String test) {
		this.userRoleId=urid;
		this.userInfo=user;
		this.test=test;
	}
	
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}
	
	
}
