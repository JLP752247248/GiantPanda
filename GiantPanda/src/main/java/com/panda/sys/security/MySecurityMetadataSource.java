package com.panda.sys.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

@Component("mySecurityMetadataSource")
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	//private static final Log logger = LogFactory.getLog(DaoInvocationSecurityMetadataSource.class);
    //private static boolean logDebug = logger.isDebugEnabled();
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		if ((object == null) || !this.supports(object.getClass())) {
            throw new IllegalArgumentException("对不起,目标对象不是类型");
        }
        Collection<ConfigAttribute> list = new ArrayList<ConfigAttribute>();
        list.add(new SecurityConfig("User"));
        FilterInvocation fi = (FilterInvocation) object;
        HttpServletRequest request = fi.getHttpRequest();
        String requestUrl = fi.getRequestUrl();
       /* if (logDebug) {
            logger.debug("通过权限过滤器 请求url = " + requestUrl + " 请求类型 = " + request.getMethod());
        }*/
        
        return  list;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
