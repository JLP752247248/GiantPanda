package com.panda.learn.javase;

import org.junit.Test;

public class JavaData {

	@Test
	public void testDataType(){
		int i=0,j=0;
		System.out.println(i++);
		System.out.println(i++==2);
		System.out.println(++j);
		System.out.println(++j==2);
		System.out.println(0x0021);
		System.out.println(0x9990);
		System.out.println((long)Math.pow(2, 31));//2147483648
		int _int=-2147483648;
		byte _byte=-128;//8位，一共可表示2^8个数，正负除以二，就是2^7=128个，空出以为来表示符号，再从正数里找一位表示0
		
		/*for(int i=-128;i<128;i++){
			System.out.println(Integer.toBinaryString(i)+"  "+i);
		}*/
		System.out.println(0xffffffff);
	}
}
