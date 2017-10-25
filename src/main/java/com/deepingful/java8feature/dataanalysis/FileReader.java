package com.deepingful.java8feature.dataanalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FileReader {

	public static Set<String> logininFile2Set(String filepath) throws IOException{
		Set<String> set=null;
		try(BufferedReader bufferedReader=Files.newBufferedReader(Paths.get(filepath))){
			set=bufferedReader.lines().filter(line->line.length()>0 && line.split(",").length == 2).map(line->line.split(",")[1]).collect(Collectors.toSet());
		}
		return set;
	}
	
	public static Set<String> getSpecificId(String filepath,String userid) throws IOException{
		Set<String> set=null;
		try(BufferedReader bufferedReader=Files.newBufferedReader(Paths.get(filepath))){
			set=bufferedReader.lines().filter(line->line.length()>0 && line.split(",").length == 2 && line.split(",")[1].trim().equals(userid)).map(line->line.split(",")[0].trim()).collect(Collectors.toSet());
		}
		return set;
	}
	
	public static Set<String> getSpecificDay(String filepath,String statisday) throws IOException{
		Set<String> set=null;
		try(BufferedReader bufferedReader=Files.newBufferedReader(Paths.get(filepath))){
			set=bufferedReader.lines().filter(line->line.length()>0 && line.split(",").length == 2 && line.split(",")[0].trim().equals(statisday)).map(line->line.split(",")[1].trim()).collect(Collectors.toSet());
		}
		return set;
	}
	
	public static void main(String[] args) throws IOException {
		long startTime=System.currentTimeMillis();
		String filepath="/Users/liufeng/yuewen/dataanalysis/loginincheck/logincheck.csv";
//		Set<String> set=logininFile2Set(filepath);
		Set<String> set=getSpecificId(filepath, "114944988");
		TreeSet<String> treeset=new TreeSet<>(set);
//		Collections.sort(set, Comparator.comparing(String::toString));
		System.out.println(treeset.size());
		treeset.stream().forEach(System.out::println);
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
//		int[][] longindate=new int[4984912][];
		
		Set<String> statisdaySet=getSpecificDay(filepath, "20170322");
		System.out.println(statisdaySet.size());
	}

}
