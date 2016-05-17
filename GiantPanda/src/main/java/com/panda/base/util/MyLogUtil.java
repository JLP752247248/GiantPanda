package com.panda.base.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyLogUtil {

	public static synchronized void writeToFile( File file,String methodName)
	{
		
			try {
				if(!file.exists())
					{file.createNewFile();}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		FileWriter out=null;
		try {
		String s=methodName+":"+Thread.currentThread();
		out=new FileWriter(file,true);
		
		out.append(s+"\r\n");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}

	public static void writeToFile(String methodName) {
		writeToFile(new File("E://log.txt"),methodName);
	}
}
