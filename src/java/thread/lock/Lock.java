package com.sandbox.thread.lock;

/**
 * @author Francisco Franco
 *
 * Lock thread monitor object
 */

public class Lock {
	private boolean isLocked = false;
	//private Thread lockedBy = null;
	//private int lockCount = 0;
	//private int MAX_THREADS = 10;
	//private Object monitorObj = new Object();
	
	public synchronized void lock() throws InterruptedException {
		Thread callingThread = Thread.currentThread();
		System.out.println("CallingThread is: " + callingThread);
		//while (isLocked && lockedBy != callingThread) {
		while (isLocked) {
			//synchronized(monitorObj) {
			wait();
		}
		//}
		//lockCount++;
		//System.out.println("LOCK COUNT IS: " + lockCount);
	  //if (lockCount == MAX_THREADS) {
		System.out.println("LOCKING");
		isLocked = true;
	}
	//lockedBy = callingThread;
	//}
	
	public synchronized void unlock() {
		//if (Thread.currentThread() == this.lockedBy) {
		//lockCount--;
		//if (lockCount == 0 && isLocked) {
		//if (isLocked) {
		//synchronized(monitorObj) {
		System.out.println("UNLOCKING");
		isLocked = false;
		notify();
	}
	//}
	//}
	//}
}
