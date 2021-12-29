package com.assignment8test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.assignment8.Assignment8;

public class Assignment8Test {
	
/*
	@Test
    public void getData () {

        Assignment8 assignment = new Assignment8();
       

        for (int i=0; i<1000; i++) {

            List<Integer> numbersList = assignment.getNumbers();

            System.out.println(numbersList);

        }

    }
*/
	
	@Test
	public void getDataAsync () {
		
		Assignment8 a8 = new Assignment8();
		
		ExecutorService eServIO = Executors.newCachedThreadPool();
		ExecutorService eServCPU = Executors.newFixedThreadPool(5);

		List<CompletableFuture<Void>> allBatch = new ArrayList<>();
		List<Integer> allNum = new ArrayList<>();
		Map<Integer, Long> count = new HashMap<>();
		
		for(int i=0; i<1000; i++) {
			CompletableFuture<Void> batch = CompletableFuture
															 .supplyAsync(() -> a8.getNumbers(), eServCPU)
															 .thenAcceptAsync(numList -> allNum.addAll(numList), eServIO);
				
			
			
			allBatch.add(batch);			
		}
	
		while(allBatch.stream()
				   .filter(CompletableFuture::isDone)
				   .count() < 1000){
					   
				   }
			
		System.out.println("Total elements: " + allNum.size());
		
		Map<Integer, Long> result = allNum.stream()
			  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println("Unique elements: " + result.size());
		System.out.println("Total occurences: " + result.toString().replace("{", "").replace("}", ""));
		
	}

}
