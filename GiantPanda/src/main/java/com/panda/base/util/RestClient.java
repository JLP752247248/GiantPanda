package com.panda.base.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * 调用RestfulService工具类
 * 
 * @author jlp
 *
 */
public class RestClient {
	public enum RequestMethod {
		GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
	}

	/**
	 * 
	 * @param url
	 * @param reqParamObj
	 * @return
	 * @throws Exception 
	 */
	public static String sendGet(String url, Object param) throws Exception {
		if (param instanceof Map) {
			return sendGet(url, (Map<String, Object>) param);
		} else if (param instanceof String) {
			return sendGet(url, (String) param);
		} else {
			throw new RuntimeException("sendGetObj要求入参为String或者Map类型！！！");
		}
	}

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是hashmap的形式。
	 * @return URL所代表远程资源的响应
	 * @throws Exception 
	 */
	public static String sendGet(String url, Map<String, Object> map) throws Exception {
		String param = "";
		for (String key : map.keySet()) {
			try {
				param += ("&" + URLEncoder.encode(key, "utf-8") + "=" + URLEncoder
						.encode(map.get(key).toString(), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		param = "".equals(param) ? "" : param.substring(1);
		return sendGet(url, param);
	}

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是name1=value1&name2=value2的形式。
	 * @return URL所代表远程资源的响应
	 */
	public static String sendGet(String url, String param) throws Exception{
		String result = "";
		BufferedReader in = null;
		try {
			String urlName = url + (url.contains("?") ? "" : "?") + param;
			URL realUrl = new URL(urlName);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 建立实际的连接
			conn.connect();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				//Thread.sleep(2*1000);
				result += line;
			}
			/*int per=(int) (Math.random()*10);
			Thread.sleep(per*1000);*/
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定URL发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            任意对象
	 * @return URL 所代表远程资源的响应
	 * @throws Exception 
	 */
	public static String sendPost(String url, Object param) throws Exception {
		return sendPostOrPut(url, param, "POST");
	}

	public static String sendPostOrPut(String url, Object param,
			String methodType) throws Exception {
		BufferedReader in = null;
		String result = "";
		URL realUrl = new URL(url);
		// 打开和URL之间的连接
		HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
		conn.setRequestMethod(methodType);
		// 设置通用的请求属性
		conn.setRequestProperty("accept", "*/*");
		conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		conn.setRequestProperty("connection", "Keep-Alive");
		conn.setRequestProperty("user-agent",
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
		// 发送POST请求必须设置如下两行
		conn.setDoOutput(true);
		conn.setDoInput(true);
		//System.out.println(JSONObject.toJSONString(param));
		//System.out.println(conn.getRequestProperties().toString());
		// 获取URLConnection对象对应的输出流
		//out = new PrintWriter(conn.getOutputStream());
		DataOutputStream out = new DataOutputStream(conn.getOutputStream());
		// 发送请求参数
		out.write((JSONObject.toJSONString(param)).getBytes("UTF-8"));
		int per=(int) (Math.random()*10);
		//Thread.sleep(per*2000);
		// flush输出流的缓冲
		out.flush();
		// 定义BufferedReader输入流来读取URL的响应
		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = in.readLine()) != null) {
			result += line;
		}
		// 使用finally块来关闭输出流、输入流
		if (out != null) {
			out.close();
		}
		if (in != null) {
			in.close();
		}
		return result;
	}

	/**
	 * 向指定URL发送PUT方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是name1=value1&name2=value2的形式。
	 * @return URL所代表远程资源的响应
	 * @throws Exception 
	 */
	public static String sendPut(String url, Object param) throws Exception {
		return sendPostOrPut(url, param, "PUT");
	}

	/**
	 * 向指定URL发送DELETE方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @return URL所代表远程资源的响应
	 */
	public static String sendDelete(String url) {
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl
					.openConnection();
			conn.setRequestMethod("DELETE");
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			// System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;

	}

	/**
	 * 
	 * @param url
	 * @param methodType
	 * @param reqParamObj
	 * @return
	 * @throws Exception 
	 */
	public static String sentRequest(String url, RequestMethod methodType,
			Object reqParamObj) throws Exception {
		String strRes = "";
		switch (methodType) {
		case GET:
			strRes = RestClient.sendGet(url, reqParamObj);
			break;
		case PUT:
			strRes = RestClient.sendPut(url, reqParamObj);
			break;
		case POST:
			strRes = RestClient.sendPost(url, reqParamObj);
			break;
		case DELETE:
			strRes = RestClient.sendDelete(url);
			break;
		default:
			strRes = RestClient.sendGet(url, reqParamObj);
		}
		return strRes;
	}
	
	public static String sendPostOrPut1(String url, Object param,
			String methodType) throws Exception {
		BufferedReader in = null;
		String result = "";
		URL realUrl = new URL(url);
		// 打开和URL之间的连接
		HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
		conn.setRequestMethod(methodType);
		// 设置通用的请求属性
		conn.setRequestProperty("accept", "*/*");
		conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
		conn.setRequestProperty("connection", "Keep-Alive");
		conn.setRequestProperty("user-agent",
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
		// 发送POST请求必须设置如下两行
		conn.setDoOutput(true);
		conn.setDoInput(true);
		System.out.println(conn.getRequestProperties().toString());
		// 获取URLConnection对象对应的输出流
		//out = new PrintWriter(conn.getOutputStream());
		DataOutputStream out = new DataOutputStream(conn.getOutputStream());
		// 发送请求参数
		out.write(param.toString().getBytes("UTF-8"));
		// flush输出流的缓冲
		out.flush();
		// 定义BufferedReader输入流来读取URL的响应
		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = in.readLine()) != null) {
			result += line;
		}
		// 使用finally块来关闭输出流、输入流
		if (out != null) {
			out.close();
		}
		if (in != null) {
			in.close();
		}
		return result;
	}
}
