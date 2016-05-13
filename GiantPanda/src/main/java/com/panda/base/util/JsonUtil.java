package com.panda.base.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtil {
	private static SerializerFeature[] features = 
		 {SerializerFeature.WriteNullNumberAsZero,
		 SerializerFeature.WriteNullStringAsEmpty,
		 SerializerFeature.DisableCircularReferenceDetect};
	public static void SetResponse(HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
	}
	public static void RespondJsonString(HttpServletResponse response,Object object){
		SetResponse(response);
        String JsonString=JSON.toJSONString(object,features);
        try {
			response.getWriter().print(JsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
