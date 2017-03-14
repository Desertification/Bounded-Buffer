/**
 * Created by thoma on 13-Mar-17.
 */
public class Main {
    public static void main(String[] args) {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        Thread producerThread = new Thread(producer, "producer");
        Thread consumerThread = new Thread(consumer, "consumer");
        producerThread.setDaemon(false);
        consumerThread.setDaemon(false);
        producerThread.start();
        consumerThread.start();
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
