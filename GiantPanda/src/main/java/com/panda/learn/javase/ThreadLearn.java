package com.panda.learn.javase;
class extThread extends Thread{
	private int num=0;
	
	@Override
	public void run() {
		num++;
		System.out.println("thread1----name:"+Thread.currentThread().getName()+" num:"+num);
	}
}
class Thread2 implements Runnable{
	private int tnum=0;
	private int times=0;
	public void run() {
		tnum++;
		System.out.println("thread2----name:"+Thread.currentThread().getName()+" tnum:"+tnum);
		times++;
	}
	public int getTnum(){
		return times;
	}
	public int getTimes(){
		return times;
	}
}
public class ThreadLearn {

	
	public static void main(String[] args) {
		extThread t1=new extThread();
		extThread t2=new extThread();
		Thread2 t3=new Thread2();
		Thread2 t4=new Thread2();
		Thread2 t5=new Thread2();
		Thread2 t6=new Thread2();
		Thread2 t7=new Thread2();
		Thread2 t8=new Thread2();
		Thread2 t9=new Thread2();
		//new Thread(t1).start();
		//new Thread(t1).start();
		new Thread(t3,"A").start();
		new Thread(t3,"B").start();
		new Thread(t3,"C").start();
		new Thread(t3,"D").start();
		new Thread(t3,"E").start();
		new Thread(t3,"F").start();
		new Thread(t3,"G").start();
		System.out.println(t3.getTnum());
		System.out.println(t3.getTnum());
		System.out.println(t3.getTnum());
		System.out.println(t3.getTnum());
		System.out.println(t3.getTnum());
		System.out.println(t4.getTnum());
		//t1.start();
		//t2.start();
		
	}

}
