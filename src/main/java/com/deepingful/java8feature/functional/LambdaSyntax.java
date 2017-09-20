package com.deepingful.java8feature.functional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

import com.deepingful.java8feature.entity.User;

public class LambdaSyntax {

	public static void main(String[] args) {
//		BigDecimal bigDecimal=BigDecimal::new;
		Function<String,BigDecimal> consumer=BigDecimal::new;
		System.out.println(consumer.apply("65535"));
		Function<User, String> function=User::getFirstname;
		String name=function.apply(new User());
		System.out.println(name);
	}

}
