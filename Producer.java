/**
 * Created by thoma on 13-Mar-17.
 */
public class Producer extends ProducerConsumer implements Runnable {
    private int count;

    public Producer(Buffer<Integer> buffer) {
        super(buffer);
        count = 1;
    }

    @Override
    protected void runProducerConsumerTask() {
        buffer.insert(count);
        count++;
        System.out.println("Produced id: " + count + " " + buffer);
    }

}
