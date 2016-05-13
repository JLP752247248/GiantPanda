package com.panda.base.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.panda.base.dao.hibernatecallback.HqlExecuteHibernateCallback;
import com.panda.base.util.PageInfo;
@Repository
public class BaseDao<T extends Object,PK extends Serializable> extends HibernateDaoSupport implements Serializable{

	
	private static final long serialVersionUID = -7599825946856616261L;
	private String calssTName = null;
	protected Map<String, String> filterField = null;
	protected static Log log = LogFactory.getLog(BaseDao.class);
    private String calssTShortName = null;
	@Resource
    public void setSqlSessionFactory(SessionFactory sqlSessionFactory) {
        super.setSessionFactory(sqlSessionFactory);
    } 
	
	/**
	 * 获取对象列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> getObjectlist(){
		String Hql="FROM "+getClassTShortName()+" where 1=1";
		return (List<T>)this.getSession().createQuery(Hql).list();
	}
	
	/**
	 * 根据id获取单个对象	
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getObjectById(PK id){
		if (id == null)
            return null;
        try {
        	return (T) this.getSession().get(getClassTName(), id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
	}
	
	/**
	 * 新增保存，即当id在数据库不存在时
	 * @param o
	 * @return
	 */
	public Serializable saveNewObject(T o) {
        try {
        	getHibernateTemplate().persist(o);//如果数据库已经存在，那么会抛出异常
            return 1;// .persist(o);//
        } catch (RuntimeException re) {
            log.error("save new object failed", re);
            throw re;
        }finally{
        }
    }
	
	/**
	 * 直接update，id在数据库不存在会报错。
	 * @param obj
	 */
	public void updateObject(T obj){
		try {
            getHibernateTemplate().merge(obj);// .persist(o);//
            // log.debug("save or update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
	}
	
	/**
	 * 删除对象
	 * @param obj
	 */
	public void deleteObject(T obj){
		try {
            getHibernateTemplate().delete(obj);// .persist(o);//
            // log.debug("save or update successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
	}
	
	
	/**
	 * 先根据id查到对象，再删除对象
	 * @param obj
	 */
	public void deleteObjectById(PK id){
		T o = getObjectById(id);
		try {
            getHibernateTemplate().delete(o);// .persist(o);//
            // log.debug("save or update successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
	}
	
	
	/**
	 * 数据库没有id就insert，有就update，会先判断是否有实质的改变，然后再update
	 * @param o
	 */
	public void mergeObject(T o) {
        try {
            getHibernateTemplate().merge(o);// .persist(o);//
            // log.debug("save or update successful");
        } catch (RuntimeException re) {
            log.error("margin failed", re);
            throw re;
        }
    }
	
	
	@SuppressWarnings("unchecked")
	public List<T> listObjectsByHql(String queryString,Object[]values){
		try{
			return getHibernateTemplate().find(queryString, values);
		}catch(Exception re){
			log.error("list failed",re);
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> listObjectsByHql(String queryString,Object[]values,PageInfo pageInfo){
		try{
			return  (List<Object>) getHibernateTemplate().execute(new HqlExecuteHibernateCallback(queryString,values,pageInfo));
		}catch(Exception re){
			log.error("list failed",re);
			return null;
		}
	}
	
	
	
	
	
	
	public final String getClassTName() {
	        if (calssTName == null) {
	            ParameterizedType genType = (ParameterizedType) getClass().getGenericSuperclass();
	            Type[] params = genType.getActualTypeArguments();
	            calssTName = ((Class<?>) params[0]).getName();
	        }
	        return calssTName;
	}
	
	public final String getClassTShortName() {
        if (calssTShortName == null) {
            ParameterizedType genType = (ParameterizedType) getClass().getGenericSuperclass();
            Type[] params = genType.getActualTypeArguments();
            calssTShortName = ((Class<?>) params[0]).getSimpleName();
        }
        return calssTShortName;
    }
	public Map<String, String> getFilterField() {
        return filterField;
    }
	
}
