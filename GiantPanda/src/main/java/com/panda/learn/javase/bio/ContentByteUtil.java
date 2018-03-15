package com.panda.learn.javase.bio;
public class ContentByteUtil{

	public static void main(String [] args){
		System.out.println("file.encoding:" + System.getProperty("file.encoding"));  
        System.out.println("sun.jnu.encoding:" + System.getProperty("sun.jnu.encoding")); 
	while(true){

		try {
			Thread.sleep(1000);
			System.out.println(new String("我的南京北京呵呵呵".getBytes(),"GBK"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("jkjkjkjkk");
	}
	}
}

