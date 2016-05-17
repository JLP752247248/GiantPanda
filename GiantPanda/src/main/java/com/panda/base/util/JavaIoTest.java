package com.panda.base.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.util.regex.Pattern;

import org.junit.Test;

public class JavaIoTest {
	/**
	 * @throws IOException
	 * 
	 */
	public static void main(String args[]) throws IOException {
		File path = new File("E:");
		// File file=new File(path,"demo.txt");
		File file = new File("E:\\demo.txt");
		File file_dir = new File("E:\\dir");
		String[] dir = file_dir.list(new DirFilter("[a-z]|.+pdf"));
		System.out.println(dir.length);
	}

	@Test
	public void fileOpt() throws IOException {
		File f = new File("D:\\myfile.txt");
		if (!f.exists()) {
			f.createNewFile();
		}
		// else
		// f.delete();

	}

	@Test
	public void listDirectory() throws IOException {
		File f = new File("E:\\myDir");
		listDirectory(f, 0);
	}

	public void listDirectory(File f, int size) {
		if (f.isDirectory()) {
			System.out.println(blank(size) + "--" + f.getName() + ":");
			for (String fson : f.list()) {
				listDirectory(new File(f, fson), size + 1);
			}
		} else {
			System.out.println(blank(size) + f.getName());
		}
	}

	@SuppressWarnings("resource")
	@Test
	public void useRandomAccessFileC() throws FileNotFoundException,IOException{
		File f=new File("E:\\testRandom.txt");
		RandomAccessFile rdFile=new RandomAccessFile(f,"rw");
		rdFile.writeBytes("����#jkfkljs  ");
		rdFile.close();
	}

	public String blank(int size) {
		String b = "";
		while (size > 0) {
			b = b + "  ";
			size--;
		}
		return b;
	}

	
	@Test
	public void testOutInputStream(){
		File f= new File("E:\\demo.txt");
		OutputStream out=null;
		try {
			out=new FileOutputStream(f,true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str="what the fuck!";
		byte b[]=str.getBytes();
		try {
			out.write(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInputStream(){
		File f= new File("E:\\demo.txt");
		InputStream in=null;
		InputStream in1=null;
		try {
			in=new FileInputStream(f);
			in1=new FileInputStream(f);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte b[]=new byte[1024];
		byte b1[]=new byte[1025];
		int x=0;
		int count=0;
		int size=0;
		try {
			size=in.read(b1, 1, 1024);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0;i<b.length;i++){
			try {
				if((x=in.read())!=-1)
					{b[i]=(byte)x;
					count++;
					}
				//System.out.println(new String(new byte[]{b[i]}));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			in.close();
			in1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(size);
		System.out.println(new String(b,0,count));
	}
	@Test
	public void testInputStream1(){
		File f= new File("E:\\demo.txt");
		InputStream in=null;
		try {
			in=new FileInputStream(f);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte b[]=new byte[1024];
		int count=0;
		try {
			count=in.read(b);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(new String(b,0,count));
	}
	@Test
	public void testWritter(){
		File f=new File("E:\\writter.txt");
		Writer out=null;
		try {
			out=new FileWriter(f,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str="what the fuck writter?";
		try {
			out.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testReader(){
		File f=new File("E:\\writter.txt");
		Reader r=null;
		try {
			r=new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char c[]=new char[1024];
		int count=0;
		try {
			count=r.read(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(new String(c,0,count));
	}
	
	
	
	@Test
	public void testCopy(){
		File file=new File("E:\\copy.txt");
		InputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(!file.exists())
				file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File filecopy=new File("F:");
		try {
			
			System.out.println("�ļ���С��"+String.valueOf(fis.available()/1000)+"k");
			long start=System.currentTimeMillis();
			new FileCopy().copy_stream(file, filecopy);
			long end =System.currentTimeMillis();
			System.out.println("copy_stream��ʱ��"+(end-start)+"ms");
			start=System.currentTimeMillis();
			new FileCopy().copy_channel(file, new File("F:\\copy_chanel"));
			end =System.currentTimeMillis();
			System.out.println("copy_channel��ʱ��"+(end-start)+"ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testPrintStream(){
		PrintStream print=System.out;
		PrintStream print1=System.out;
		print.append("333");
		//print.append("123456789", 1,2);
		print1.append("444");
		//System.out.println(print.toString());
		//print.
	}
	
	
	
}

class DirFilter implements FilenameFilter {
	private Pattern pattern;
	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
}
