package com.sandbox.thread;

/**
 * @author Francisco Franco
 *
 * Consumer class that gets messages from a queue
 */

public class Consumer extends Thread {
	Producer producer;
	
	private Consumer(Producer p) {
		producer = p;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("ABOUT TO SLEEP");
				sleep(5000);
				String message = producer.getMessage();
				System.out.println("GOT:   " + message);
				//sleep(200);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Main method to execute functions above
	public static void main(String[] args) {
		Producer producer = new Producer();
		producer.start();
		new Consumer(producer).start();
	}
}
