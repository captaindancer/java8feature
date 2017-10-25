package com.deepingful.java8feature.functional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.text.DateFormatter;

import com.deepingful.java8feature.entity.User;

public class LambdaSyntax {

	
	public static void main(String[] args) {
//		BigDecimal bigDecimal=BigDecimal::new;
		Function<String,BigDecimal> consumer=BigDecimal::new;
		System.out.println(consumer.apply("65535"));
		Function<User, String> function=User::getFirstname;
		String name=function.apply(new User());
		System.out.println(name);
		
		new Thread(()->System.out.println("in other thread")).start();
		
		int[] arrayInt=new int[]{100,200,300,400,500};
		Arrays.stream(arrayInt).forEach(System.out::println);
		Arrays.stream(arrayInt).map(element->element*element).forEach(System.out::println);
		Arrays.stream(arrayInt).forEach(System.out::println);
		System.out.println(Arrays.stream(arrayInt).reduce(0, (sum,value)->sum+value));
		System.out.println("reduce");
		Arrays.stream(arrayInt).reduce(0, (sum,value)->{
			System.out.println(sum);
			return sum+value;
		});
		Arrays.stream(arrayInt).reduce((sum,value)->{
			System.out.println(sum);
			return sum+value;
		});
		String[] arrayString=new String[]{"yuewen","qqbook","qidian"};
		System.out.println(Arrays.stream(arrayString).collect(Collectors.joining(",")));
//		System.out.println(Arrays.stream(arrayInt).map((element)->String.valueOf(element)).collect(Collectors.joining(",")));
		Stream.of(arrayInt).map(element->String.valueOf(element)).forEach(System.out::println);
		Arrays.stream(arrayInt).forEach(System.out::println);
		System.out.println(Stream.of(arrayInt).map(element->String.valueOf(element)).collect(Collectors.joining(",")));
		
		System.out.println(Arrays.stream(arrayInt).min().orElse(0));
		System.out.println(Arrays.stream(arrayInt).max().orElse(0));
		System.out.println(Arrays.stream(arrayInt).average().orElse(0));
		System.out.println(Arrays.stream(arrayInt).sum());
		
		System.out.println(Arrays.stream(arrayString).min(Comparator.comparing(String::toString)).get());
		BinaryOperator<Integer> intBinaryOperator=(x,y)->x+y;
		System.out.println(intBinaryOperator.apply(3, 5));
		
		ThreadLocal<DateFormatter> threadLocal=ThreadLocal.withInitial(()->new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));
		Calendar calendar=Calendar.getInstance();
//		System.out.println(calendar);
		calendar.set(Calendar.YEAR, 1970);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(threadLocal.get().getFormat().format(calendar.getTime()));
	}

}
