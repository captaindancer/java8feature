package com.deepingful.java8feature.interfacefeature;

interface t1{
	default void print(){
		System.out.println("this is t1");
	}
	
	void helloworld();
}

interface t2{
	default void print(int index){
		System.out.println("this is t2");
	}
	
	void helloworld();
}

public class InterfaceDefaultMethod implements t1,t2{

	//注意：t1和t2中不能有同名的default方法

	@Override
	public void helloworld() {
		
	}

}
