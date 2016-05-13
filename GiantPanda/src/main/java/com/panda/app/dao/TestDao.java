package com.panda.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.panda.app.po.TestEntity;
import com.panda.base.dao.BaseDao;
import com.panda.base.util.PageInfo;

@Repository
public class TestDao extends BaseDao<TestEntity,Integer>{
	private static final long serialVersionUID = 1L;

    public List<Object> listUsers(){
    	String Hql="from UserInfo where 1=1";
    	PageInfo pageInfo=new PageInfo(1,5);
    	return this.listObjectsByHql(Hql, null, pageInfo);
    	
    }
}
