/**
 * 
 */
/**
 * @author jlp
 *
 */
package com.panda.learn.javase.init;
public class InitOrder{
	
	public static class InitClass{
		static {
			System.out.println("init static");
		}
		InitClass(int i){
			System.out.println(i);
		}
	}
	private int i;
	InitClass c1=new InitClass(1);
	InitOrder(){
		System.out.println("i"+i);
		InitClass c2=new InitClass(2);
	}
	InitClass c3=new InitClass(3);
	static {
		System.out.println("static");
	}
	public static InitClass cstatic=new InitClass(999);
	public static void main(String[] args) {
		//InitOrder  io=new InitOrder();
	}
}