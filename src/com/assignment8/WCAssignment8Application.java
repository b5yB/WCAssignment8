package com.assignment8;

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


public class WCAssignment8Application {

	public static void main(String[] args) {
		Assignment8 a8 = new Assignment8();
		
		ExecutorService eServIO = Executors.newCachedThreadPool();
		
		List<Integer> allNum = Collections.synchronizedList(new ArrayList<>(1000));
		
		List<CompletableFuture<Void>> allBatch = new ArrayList<>(1000);
		
		for (int i=0; i<1000; i++) {
			CompletableFuture<Void> batch = 
				CompletableFuture.supplyAsync(() -> a8.getNumbers(), eServIO)
								 .thenAccept(numbers -> allNum.addAll(numbers));
			allBatch.add(batch);
		}
		
		while (allBatch.stream().filter(CompletableFuture::isDone).count() < 1000 ) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
		
		System.out.println("Total Elements: " + allNum.size());
		
		Map<Integer, Integer> output = allNum.stream()
				  .collect(Collectors.toMap(i -> i, i -> 1, (oldNum, newNum) -> oldNum + 1));
		
		System.out.println("Unique elements: " + output.size());
		System.out.println(output);
		
	}

}
