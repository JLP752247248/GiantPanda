package com.panda.sys.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="SYS_ROLEINFO")
public class RoleInfo {
	@Id
	@Column(name="ROLEID")
	@GenericGenerator(name="hibernate-uuid", strategy="uuid")  
    @GeneratedValue(generator="hibernate-uuid")  
	private String roleId;
	
	@Column(name="ROLENAME")
	private String roleName;
	
	@Column(name="ENABLE")
	private int enable;

	public RoleInfo(String roleId, String roleName, int enable) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.enable = enable;
	}
	
	
}
