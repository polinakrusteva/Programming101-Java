package week08;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

	private static AtomicInteger c = new AtomicInteger(0);
	
	public static void increment(){
		c.getAndIncrement();
	}
	
	public static void decrement(){
		c.getAndDecrement();
	}
	
	public static int getCounter(){
		return c.get();
	}
}
