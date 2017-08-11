package com.sandbox.thread.lock;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author Francisco Franco
 *
 * Counter class that increments counter 
 * via Lock.lock and Lock.unlock methods
 */

public class Counter {
	private Lock lock = new Lock();
	private int counter = 0;

	private void test(final int threadCount) throws InterruptedException, ExecutionException {
    //final BrokenUniqueIdGener domainObject = new BrokenUniqueIdGenerator();
    Callable<Integer> task = new Callable<Integer>() {
			@Override
			public Integer call() {
				//return domainObject.nextId();
				int myCount = increment();
				return myCount;
			}
    };
    List<Callable<Integer>> tasks = Collections.nCopies(threadCount, task);
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    List<Future<Integer>> futures = executorService.invokeAll(tasks);
    List<Integer> resultList = new ArrayList<Integer>(futures.size());
    // Check for exceptions
    for (Future<Integer> future : futures) {
			// Throws an exception if an exception was thrown by the task.
			resultList.add(future.get());
    }
    // Validate the IDs
    //Assert.assertEquals(threadCount, futures.size());
    List<Integer> expectedList = new ArrayList<Integer>(threadCount);
    for (int i = 1; i <= threadCount; i++) {
			expectedList.add(i);
    }
    Collections.sort(resultList);
    //Assert.assertEquals(expectedList, resultList);
	}
	
	public int increment() {
		System.out.println("INVOKING increment ...");
		int myCount = 0;
		try {
			lock.lock();
			myCount = ++counter;
			System.out.println("myCount is: " + myCount);
			lock.unlock();
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		return myCount;
	}
	
	public static void main(String[] args) {
		Counter counter = new Counter();
		//Runnable task1 = () -> {
		//counter.increment();
		//};
		//Runnable task2 = () -> {
		//counter.increment();
		//};
		//for (int i = 0; i < 50; i++) {
		//task1.run();
		//task2.run();
		//}
		
		try {
		counter.test(50);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
