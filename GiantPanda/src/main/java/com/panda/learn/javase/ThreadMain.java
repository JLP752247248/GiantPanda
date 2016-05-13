package com.panda.learn.javase;

import org.junit.Test;

public class ThreadMain {
	
	@Test
	public  void test(){
		Dispacher dis=new Dispacher();
		System.out.println("初始dis"+dis);
		
		Thread t1=new Thread(new DisThread(dis));
		Thread t2=new Thread(new DisThread(dis));
		Thread t3=new Thread(new DisThread(dis));
		t1.start();
		t2.start();
		t3.start();
		
	}
}

class DisThread implements Runnable{
	Dispacher dis=null;
	DisThread(Dispacher dis1){
		this.dis=new Dispacher();
	};
	public void run(){
		dis.addInst(dis);
		System.out.println("thread:"+Thread.currentThread()+" dis:"+dis.getDisInst());
	}
	
}