package com.panda.learn.javase.cla;

public class ClassLoaderLearn {

	public static void main(String[] args) {
		ClassLoaderLearn cll=new ClassLoaderLearn();
		ClassLoader cl=String.class.getClassLoader();
		System.out.println(String.class.getClassLoader());
		System.out.println(ClassLoaderLearn.class.getClassLoader());
		System.out.println(cll.getClass().getClassLoader());
		System.out.println(String.class.getClassLoader());
		System.out.println(Thread.currentThread().getContextClassLoader());
	}

}
