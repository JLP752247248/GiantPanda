/**
 * 
 */
/**
 * @author jlp
 *
 */
package com.panda.learn.javase.cla;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;


public class ClassLearn {

	public static void main(String[] args) {
		try {
			URL[] urls=new URL[]{new URL("file:E:\\GitHub\\GiantPanda\\GiantPanda")};
			File classFile=new File("E:\\GitHub\\GiantPanda\\GiantPanda\\target\\classes\\com\\panda\\learn\\javase\\bio\\TestCla.class");
			URLClassLoader classloader=new URLClassLoader(urls,ClassLearn.class.getClassLoader());
			Class<?> cl1=classloader.loadClass("com.panda.learn.javase.bio.TestCla");
			System.out.println(cl1.getClassLoader());
			long firestModTime=classFile.lastModified();
			System.out.println("-------------------");
			while(true){
				if(classFile.lastModified()>firestModTime){
					classloader=new URLClassLoader(urls,ClassLearn.class.getClassLoader());
					cl1=classloader.loadClass("com.panda.learn.javase.bio.TestCla");
					System.out.println(cl1.getClassLoader());
					firestModTime=classFile.lastModified();
					Object instance=cl1.newInstance();
					Object res=cl1.getMethod("getA").invoke(instance);
					System.out.println("TestCla Modified!!!"+" "+res.toString());
					//classloader.close();
					classloader=null;
					instance=null;
					res=null;
					System.gc();
				}
				Thread.sleep(3000);
			}
			/*System.out.println(classFile);
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.setLogStream(System.out);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnic"
					+ "ode=true&characterEncoding=UTF-8", "root", "1234");*/
			
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}