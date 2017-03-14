import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Random;

/**
 * Created by thoma on 13-Mar-17.
 */
public class ProducerConsumer implements Runnable {
    protected Buffer<Integer> buffer;
    private boolean stopping;
    private Random random = new Random();

    public ProducerConsumer(Buffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (!stopping) {
            runProducerConsumerTask();
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void runProducerConsumerTask() {
        throw new NotImplementedException();
    }

    ;

    public void requestStop(boolean stopping) {
        this.stopping = stopping;
    }
}
