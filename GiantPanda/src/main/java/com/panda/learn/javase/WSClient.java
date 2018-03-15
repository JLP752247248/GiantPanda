package com.panda.learn.javase;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.tomcat.jni.Global;

/**
 * 调用Webservice接口工具类
 * 
 * @author jlp
 *
 */
public class WSClient {
	public static String call(String url, String targetNamespace,String paramNameSpace,
			String method, Object[] param) throws Exception {
		Service service = new Service();
		String result = "";
		Call call = null;
		call = (Call) service.createCall();
		QName qname = new QName(targetNamespace, method);
		call.setTimeout(4000);
		call.setOperationName(qname);
		call.setTargetEndpointAddress(new java.net.URL(url));
		//QName qnameParams = org.apache.axis.encoding.XMLType.XSD_NORMALIZEDSTRING;
		/*if(!StringUtil.IsEmpty(paramNameSpace)){
			qnameParams=new QName(paramNameSpace);
		}*/
		call.addParameter("param",org.apache.axis.encoding.XMLType.XSD_ANYTYPE, javax.xml.rpc.ParameterMode.IN);
		call.setReturnClass(String.class);
		result = (String) call.invoke(param);
		return result;
	}

	public static String call(String url, String targetNamespace,String paramNameSpace,
			String method, String param) throws Exception {
		return call(url, targetNamespace,paramNameSpace,method, new Object[] { param });
	}
}
