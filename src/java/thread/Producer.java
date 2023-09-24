package com.sandbox.thread;

import java.util.Date;
import java.util.Queue;
import java.util.LinkedList;

/**
 * @author Francisco Franco
 *
 * Producer class that puts messages into a queue
 * for a given max queue size
 */
 
public class Producer extends Thread {
	private static final int MAXQUEUE = 5;
	private int counter = 0;
	private Queue<String> msgQueue = new LinkedList<String>();

	private synchronized void putMessage() throws InterruptedException {
		// Only wait if queue is full
		if (msgQueue.size() == MAXQUEUE) {
			// Thread gives up lock and goes to sleep
			wait();
			System.out.println("PUT AWAKE!");
		}
		//msgQueue.add(new Date().toString());
		String message = "message" + String.valueOf(++counter);
		msgQueue.add(message);
		System.out.println("PUT: " + message);
		notify();
		//Later, when the necessary event happens, the thread that is running it calls notify() from a block synchronized on the same object.
	}

	// Called by Consumer
	public synchronized String getMessage() throws InterruptedException {
		if (msgQueue.size() != MAXQUEUE) {
			notify();
			// This wait guarantees one PUT at a time before this method returns
			wait();
		}
		if (msgQueue.size() == 0) {
			wait();//By executing wait() from a synchronized block, a thread gives up its hold on the lock and goes to sleep.
		}
		// Retrieve but not remove head of queue
		String message = msgQueue.peek();
		// Remove the head of the queue
		msgQueue.remove();
		return message;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				putMessage();
			}
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
	
