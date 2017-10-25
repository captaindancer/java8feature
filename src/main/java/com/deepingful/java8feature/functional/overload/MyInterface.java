package com.deepingful.java8feature.functional.overload;

import java.util.function.Predicate;

public interface MyInterface {

	boolean check(IntPred intPred);
	
	boolean check(Predicate<Integer> predicate);
}
