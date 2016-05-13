package com.panda.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
@Repository
public class UserInfoJdbcDao extends JdbcDaoSupport{
	@Resource
	public void setDataSource1(DataSource datasource){
		super.setDataSource(datasource);
	}
	public void add(String id,String name){
		
		Connection conn=this.getConnection();
		String sql="insert into sys_userinfo(userId,userName) values(?,?)";
		
			try {
				PreparedStatement pre=conn.prepareStatement(sql);
				pre.setString(1, id);
				pre.setString(2, name);
				pre.executeUpdate();
				conn.commit();
				pre.close();
				} catch (SQLException e) {
				e.printStackTrace();
			}finally{
					try {
						
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		
	}
}
