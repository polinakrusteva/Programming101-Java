package monday;

public class ProducerConsumerPattern {

	public static void main(String[] args) throws InterruptedException {
		BlockQueue<Integer> sharedQueue = new BlockQueue<>(500);

		int elements = 500;
		int numberProudcers = 4;
		int numberConsumers = 5;
	
		Thread[] producers = new Thread[numberProudcers];
		Thread[] consumers = new Thread[numberConsumers];
		
		long begin = System.currentTimeMillis();

		for(int i = 0; i <  numberProudcers; i++){
			producers[i] = new Thread(new Producer(sharedQueue, elements));
		}
		
		for(int i = 0; i < numberConsumers; i++){
			consumers[i] = new Thread(new Consumer(sharedQueue, elements));
		}
	
		for(Thread producer : producers){
			producer.start();
		}
		
		for(Thread consumer : consumers){
			consumer.start();
		}
		
		for(Thread producer : producers){
			producer.join();
		}
		
		for(Thread consumer : consumers){
			consumer.join();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - begin);

	}

}
