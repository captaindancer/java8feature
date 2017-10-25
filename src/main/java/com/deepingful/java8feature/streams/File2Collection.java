package com.deepingful.java8feature.streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class File2Collection {
	
	public static Set<String> getSet4FileNew(String filepath) throws IOException{
		Set<String> set=null;
		try(BufferedReader bufferedReader=Files.newBufferedReader(Paths.get(filepath))){
			set=bufferedReader.lines().filter(line->line.length()>0 && !line.equals("null")).map(line->line.trim()).collect(Collectors.toSet());
		}
		return set;
	}

	public static Set<String> getSet4FileOld(String filepath) throws IOException{
		Set<String> set=new HashSet<>();
		String line=null;
		try(BufferedReader bufferedReader=new BufferedReader(new FileReader(filepath))){
			while((line=bufferedReader.readLine()) != null){
				if(line.length()>0 && !line.equals("null")){
					set.add(line.trim());
				}
			}
		}
		return set;
	}
	
	public static void main(String[] args) throws IOException {
		long startTime=System.currentTimeMillis();
		String subscribeUserids="/Users/liufeng/yuewen/booklist/activeusers/subscribeuserids";
		Set<String> subscribeSet=getSet4FileNew(subscribeUserids);
//		Set<String> subscribeSet=getSet4FileOld(subscribeUserids);
		System.out.println(subscribeSet.size());
		String weekusers="/Users/liufeng/yuewen/booklist/activeusers/t_ed_qidian_weekactiveusers.log";
		Set<String> weekusersSet=getSet4FileNew(weekusers);
		System.out.println(weekusersSet.size());
		boolean activeUsers=subscribeSet.retainAll(weekusersSet);
		System.out.println(activeUsers);
		System.out.println(subscribeSet.size());
		String result="/Users/liufeng/yuewen/booklist/activeusers/dayactiveusers";
		try(BufferedWriter bufferedWriter=Files.newBufferedWriter(Paths.get(result))){
//			bufferedWriter.write("");
			subscribeSet.stream().forEach(element->{
				try {
					bufferedWriter.write("20170921,"+element);
					bufferedWriter.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}

}
