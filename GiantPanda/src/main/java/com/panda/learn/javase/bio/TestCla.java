package com.panda.learn.javase.bio;

public class TestCla {
	private int a;
	{
		System.out.println("iitddeedd");
		a=133;
	}
	static {
		System.out.println("static init ");
	}
	public TestCla(){
		a=90900;
	}
	public TestCla(int a){
		a=9088;
	}
	public int getA(){
		return a;
	}
}
