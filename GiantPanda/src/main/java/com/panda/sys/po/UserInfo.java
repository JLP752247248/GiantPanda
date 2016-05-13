package com.panda.sys.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.authority.GrantedAuthorityImpl;


@Entity
@Table(name="SYS_USERINFO")
public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USERID")
	/*@GenericGenerator(name="hibernate-uuid", strategy="uuid")  
    @GeneratedValue(generator="hibernate-uuid")  */
	private String userId;
	
	@Column(name="USERNAME")
	private String userName;
	
	@OneToMany(mappedBy="userInfo")
	private List<UserRole> userRoleList;
	
	@Column(name="PASSWORD")
	private String password;

	@Transient
	private Collection <GrantedAuthorityImpl> authorities;

	public UserInfo(){
		
	}
	
	public UserInfo(String userId,String userName){
		this.userId=userId;
		this.userName=userName;
		this.password="";
		
		this.userRoleList=new ArrayList<UserRole>();
	}
	
	UserInfo(String userId,String userName,String password){
		this.userId=userId;
		this.userName=userName;
		this.password=password;
		
		this.userRoleList=new ArrayList<UserRole>();
	}
	


	public List<UserRole> getUserRoleList() {
		if(null==userRoleList)
			userRoleList=new ArrayList<UserRole>();
		return userRoleList;
	}






	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}






	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<GrantedAuthorityImpl> getAuthorities() {
		if(null==authorities)
			authorities=new HashSet();
		return authorities;
	}

	public void setAuthorities(Collection<GrantedAuthorityImpl> authorities) {
		this.authorities = authorities;
	}
	
	
}
