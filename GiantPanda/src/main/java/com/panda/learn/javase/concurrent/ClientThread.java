package com.panda.learn.javase.concurrent;

import com.panda.base.util.RestClient;

public class ClientThread implements Runnable{
	private String url="http://localhost:8086/TomcatLearn/server";
	private String param="value=90&key=size";
	int num=0;
	public ClientThread(int i) {
		num=i;
		param+="&num="+i;
	}
	@Override
	public void run() {
		try{
			TestMain.plusAliveCount();
			try {
				int per=(int) (Math.random()*10);
				Thread.sleep(per*500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Thread ct=Thread.currentThread();
			StringBuilder bd=new StringBuilder();
			while(num>0){
				bd.append("x");
				num--;
			}
			String res=ct.getName()+RestClient.sendPost(url, bd.toString());
		}catch(Exception e){
			System.err.println(e.getMessage());
			TestMain.errCount++;
		}
		finally{
			TestMain.minusAliveCount();
		}
	}
}
