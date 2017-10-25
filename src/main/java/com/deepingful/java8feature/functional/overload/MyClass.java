package com.deepingful.java8feature.functional.overload;

import java.util.function.Predicate;

public class MyClass implements MyInterface {

	@Override
	public boolean check(IntPred intPred) {
		System.out.println("in IntPred");
		return false;
	}

	@Override
	public boolean check(Predicate<Integer> predicate) {
		System.out.println("in Predicate");
		return true;
	}

	public static void main(String[] args) {
		MyClass myClass=new MyClass();
//		myClass.check((x)->x>5);
	}

}
