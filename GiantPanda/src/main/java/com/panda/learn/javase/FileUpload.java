package com.panda.learn.javase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public class FileUpload {

	public static boolean uploadFile(File file,String path){
		long start=System.currentTimeMillis();
		try{
			InputStream fis=new FileInputStream(file);
			File aimFile=new File(path,file.getName());
			if(!aimFile.exists())
				{aimFile.createNewFile();}
			FileOutputStream fos=new FileOutputStream(aimFile);
			byte bytes[]=new byte[1024*100];
			System.out.println(file.getTotalSpace());
			int i=0;
			while(fis.read(bytes)>0)
			{
				i++;
				fos.write(bytes);
				System.out.print("-");
			}
			System.out.println("times:"+i);
		}catch(Exception e){
			return false;
		}finally{
			long end=System.currentTimeMillis();
			System.out.print("usetime:"+(end-start));
		}
		return true;
	}
	public static boolean uploadFile1(File file,String path){
		long start=System.currentTimeMillis();
		try{
			FileInputStream fis=new FileInputStream(file);
			File aimFile=new File(path,file.getName());
			if(!aimFile.exists())
				{aimFile.createNewFile();}
			FileOutputStream fos=new FileOutputStream(aimFile);
			FileChannel inchannel=fis.getChannel();
			FileChannel outchannel=fos.getChannel();
			long size = inchannel.size();
            long pos = 0;
            long count = 0;
            int i=0;
            long step=1024*100;
            while (pos < size) {
            	i++;
                count = size - pos >step?step: size - pos;
                pos += outchannel.transferFrom(inchannel, pos, count);
                System.out.print("-");
            }
			System.out.println("times:"+i);
		}catch(Exception e){
			return false;
		}finally{
			long end=System.currentTimeMillis();
			System.out.print("usetime:"+(end-start));
		}
		return true;
	}
	public static void main(String[] args) {
		File test=new File("F:/vedio/vedio.rar");
		uploadFile1(test, "E:/");
		
	}

}
