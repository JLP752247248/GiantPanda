package com.panda.base.dao.hibernatecallback;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.panda.base.util.PageInfo;

public class HqlExecuteHibernateCallback implements HibernateCallback<Object>{
	
	  	private String executeHql;
	    private Object[] paramsValue;
	    private int retStartPos;
	    private int retMaxSize;
	    // a null constructor
	    public HqlExecuteHibernateCallback() {
	        executeHql = null;
	        paramsValue = null;
	        retStartPos=0;
		    retMaxSize=0;
	    }

	    // a full constructor, you can use it or setHql() to fufill the hql
	    public HqlExecuteHibernateCallback(String shql, Object[] value) {
	        executeHql = shql;
	        paramsValue = value;
	        retStartPos=0;
		    retMaxSize=0;
	    }

	    public HqlExecuteHibernateCallback(String shql, Object[] value,PageInfo pageInfo) {
	        executeHql = shql;
	        paramsValue = value;
	        retStartPos=pageInfo.getRowStart();
		    retMaxSize=pageInfo.getPageSize();
	    }
	    
	    public HqlExecuteHibernateCallback(String shql) {
	        this(shql, null);
	    }

	    public void setExecuteHql(String executeHql) {
	        this.executeHql = executeHql;
	    }

	    public void setParamsValue(Object[] paramsValue) {
	        this.paramsValue = paramsValue;
	    }

	    /**
	     * 重写HibernateCallBack,
	     *
	     * @param Session session
	     */
	    public Object doInHibernate(Session session) throws HibernateException,
	            SQLException {
	        if (executeHql == null || "".equals(this.executeHql)) {
	            throw new HibernateException("can't execute a null hql!");
	        }
	        Query query = session.createQuery(executeHql);
	        //prepareQuery(query);
	        if (paramsValue != null) {
	            for (int i = 0; i < paramsValue.length; i++) {
	                query.setParameter(i, paramsValue[i]);
	            }
	        }
	        if (retMaxSize > 0)
	        	query.setMaxResults(retMaxSize);
	        if (retStartPos >= 0)
	        	query.setFirstResult(retStartPos);
	        
	        return query.list();
	    }

	    public String getExecuteHql() {
	        return executeHql;
	    }

}
