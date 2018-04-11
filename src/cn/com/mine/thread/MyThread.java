package cn.com.mine.thread;

import java.util.HashMap;

public class MyThread implements Runnable {

	volatile int amount;
	
	public class Inner extends Thread {
		public void run() {
			try {
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		new Thread(myThread, "A").start();
		new Thread(myThread, "B").start();
	}

	int num = 50;
	String str = new String();

	@Override
	public void run() {
		synchronized (str) {
			while (num > 0) {
				if (num < 20) {
					try {
						if (Thread.currentThread().getName().equals("B")) {
							str.notify();
						}else{
							str.notify();
						}
						str.wait();
					}
					catch (IllegalMonitorStateException e) {
						e.printStackTrace();
					}
					catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1);
				}
				catch (Exception e) {
					e.getMessage();
				}
				System.out.println(Thread.currentThread().getName() + "this is " + num--);
			}
		}
	}

}
