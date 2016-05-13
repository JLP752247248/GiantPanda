package com.panda.learn.javase;

public class Dispacher {

		ThreadLocal <Dispacher> instance=new ThreadLocal<Dispacher>();
		public Dispacher getDisInst(){
			return instance.get();
		}
		public void addInst(Dispacher dis){
			instance.set(dis);
		}
		
		
}
