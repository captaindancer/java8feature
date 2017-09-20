package com.deepingful.java8feature.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class File2Collection {
	
	

	public static void main(String[] args) {
		String subscribeUserids="/Users/liufeng/yuewen/booklist/activeusers/subscribeuserids";
		Set<String> subscribeUserSet=new HashSet<>();
		subscribeUserSet.stream().filter(line->line!="null").forEach(System.out::println);
		Map<Integer, String> textMap=subscribeUserSet.stream().collect(Collectors.toMap(entry->entry.length(), entry->entry));
		Pattern pattern=Pattern.compile("//s+");
		Map<String, Long> wordFrequence=subscribeUserSet.stream().flatMap(entry->pattern.splitAsStream(entry)).collect(Collectors.groupingBy(word->word.toUpperCase(),Collectors.counting()));
		int[] arrayInt=new int[]{1,2,3,4,5,6};
		int result=0;
		result=Arrays.stream(arrayInt).sum();
		System.out.println(result);
		result=Arrays.stream(arrayInt).reduce(0, Integer::sum);
		System.out.println(result);
		OptionalInt optionalInt=Arrays.stream(arrayInt).reduce(Integer::sum);
		System.out.println(optionalInt.orElse(0));
		long[] arrayLong=new long[]{1,2,3,4,5,6};
		System.out.println(subscribeUserSet.stream().collect(Collectors.counting()));
	}

}
