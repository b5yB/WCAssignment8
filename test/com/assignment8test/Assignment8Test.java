	package com.assignment8test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


import org.junit.jupiter.api.Test;

import com.assignment8.Assignment8;

public class Assignment8Test {
	
	/*
	 *  Code to run is now WCAssignment8Application in com.assignment8 package
	 *  Thank you! 
	 */
	
//	public static List<Integer> allNum = Collections.synchronizedList(new ArrayList<>(1000));
//	
//	public static void main (String[] args) {
//		
//		Assignment8 a8 = new Assignment8();
//		
//		//Thought I needed fixedThreadPool as a crutch for my old machine... but cachedThreadPool works fine!  
//		//ExecutorService eServCPU = Executors.newFixedThreadPool(5);
//		ExecutorService eServIO = Executors.newCachedThreadPool();
//		
//		List<CompletableFuture<Void>> allBatch = new ArrayList<>();
//		
//		Map<Integer, Long> result = new ConcurrentHashMap<>();
//				
//		for(int i=0; i<1000; i++) {
//			CompletableFuture<Void> batch = CompletableFuture
//															 .supplyAsync(() -> a8.getNumbers(), eServIO)
//															 .thenAccept(numList -> toAllNum(numList));
//			
//			allBatch.add(batch);
//		}
//	
//		while(allBatch.stream()
//				   .filter(CompletableFuture::isDone)
//				   .count() < 1000){
//						try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
//				   }
//			
//		System.out.println("Total elements: " + allNum.size());
//
//		result = allNum.stream()
//					   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));			
//		
//
//		
//		System.out.println("Unique elements: " + result.size());
//		System.out.println(result.toString().replace("{", "").replace("}", ""));
//	}
//
//	
//	public static List<Integer> toAllNum (List<Integer> numList) {
//		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
//	    synchronized (numList) {
//			 allNum.addAll(numList); 
//			 }
//	    return allNum;
//	}
	
}