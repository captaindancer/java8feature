package com.deepingful.java8feature.languagefeature;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		//Optional对象的toString方法是，如果传入的为null，则打印Optional.empty，非null的话，则打印Optional[传入的值]
		//传入一个非null的值
		Optional<String> textName=Optional.of("qqbook");
		System.out.println(textName);
		if(textName.isPresent()){
			System.out.println(textName.get());
		}
		textName.ifPresent(System.out::println);
		System.out.println(textName.orElse("no value---null"));
		//传入一个null值
		Optional empty=Optional.ofNullable(null);
		System.out.println(empty);
		if(empty.isPresent()){
			System.out.println(empty.get());
		}
		empty.ifPresent(System.out::println);
		System.out.println(empty.orElse("no value---null"));
		System.out.println(empty.orElseGet("no value---null"::toUpperCase));
	}

}
