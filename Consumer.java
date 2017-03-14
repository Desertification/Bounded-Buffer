/**
 * Created by thoma on 13-Mar-17.
 */
public class Consumer extends ProducerConsumer {

    public Consumer(Buffer<Integer> buffer) {
        super(buffer);
    }

    @Override
    protected void runProducerConsumerTask() {
        Integer count = buffer.remove();
        System.out.println("Consumed id: " + count + " " + buffer);
    }

}
