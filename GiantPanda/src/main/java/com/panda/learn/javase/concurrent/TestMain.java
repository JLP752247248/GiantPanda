package com.panda.learn.javase.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestMain {
	private static int aliveCount=0;
	public static int allCount=0;
	public static int queueCount=0;
	public static int errCount=0;
	public static int lastCount=0;
	static Object lock=new Object();
	static void plusAliveCount(){
		synchronized (lock) {
				aliveCount++;
				allCount++;
		}
	}
	static void minusAliveCount(){
		synchronized (lock) {
			aliveCount--;
			queueCount--;
		}
	}
	static int getAliveCount(){
		synchronized (lock) {
			return aliveCount;
		}
	}
	static boolean canAdd(int maxSize){
		synchronized (lock) {
			return maxSize>aliveCount?true:false;
		}
	}
	public static void main(String[] args) {
		//ThreadPoolExecutor pool=new ThreadPoolExecutor(400,400, 2000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
		final ExecutorService executor=Executors.newCachedThreadPool();
		ScheduledExecutorService executor1=Executors.newScheduledThreadPool(1);
		executor1.scheduleAtFixedRate(new Runnable(){
			@Override
			public void run() {
				synchronized (lock) {
					ThreadPoolExecutor pool=(ThreadPoolExecutor) executor;
					System.out.println("pool活跃数:"+pool.getActiveCount()+
							",pool队列大小:"+pool.getQueue().size()+
							",当前线程数："+TestMain.aliveCount+",总线程数："+
							TestMain.allCount+",错误数："+TestMain.errCount+
							",新增数："+(allCount-lastCount));
					lastCount=TestMain.allCount;
					int i=0;
					while(i<200){
							TestMain.queueCount++;
							ClientThread ct=new ClientThread(i);
							executor.execute(ct);
							i++;
					}
				}
			}
		}, 0,1, TimeUnit.SECONDS);
		
	}
}
