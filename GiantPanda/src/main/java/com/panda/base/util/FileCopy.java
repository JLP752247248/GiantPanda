package com.panda.base.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public class FileCopy {

	public void copy_stream(File f1, File f2) throws Exception {
		if (!f2.isDirectory()) {
			throw new Exception(f2.getName() + "����Ŀ¼");
		} else {
			File fc = new File(f2, f1.getName());
			fc.createNewFile();
			InputStream in = new FileInputStream(f1);
			OutputStream out = new FileOutputStream(fc);
			try {
				int i = 0;
				while ((i = in.read()) != -1) {
					out.write(i);
				}
				System.out.println("������ɣ�");
			} catch (Exception e) {
				System.out.println("����ʧ�ܣ�");
			}
			try {
				in.close();
				out.close();
			} catch (Exception e) {

			}
		}
	}

	public void copy_channel(File f1, File f2) {
		File fc = new File(f2, f1.getName());
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream = new FileInputStream(f1);
			fileOutputStream = new FileOutputStream(fc);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		FileChannel inChannel = fileInputStream.getChannel();
		FileChannel outChannel = fileOutputStream.getChannel();
		try {
			int maxCount = (64 * 1024 * 1024) - (32 * 1024);
			long size = 0;
			try {
				size = inChannel.size();
				long position = 0;
				while (position < size) {
					position += inChannel.transferTo(position, maxCount,
							outChannel);
				}
				System.out.println("������ɣ�");
			} catch (IOException e) {
				System.out.println("����ʧ�ܣ�");
				e.printStackTrace();
			}
		} finally {
			try {
				if (inChannel != null) {
					inChannel.close();
				}
				if (outChannel != null) {
					outChannel.close();
				}
				fileInputStream.close();
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
