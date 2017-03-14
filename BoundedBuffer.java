/**
 * Created by thoma on 13-Mar-17.
 */
public class BoundedBuffer<T> implements Buffer<T> {
    private static final int BUFFER_MAX = 5;
    private int itemsInBuffer;
    private int freeSlot;
    private int occupiedSlot;
    private Object[] buffer;

    public BoundedBuffer() {
        itemsInBuffer = 0;
        freeSlot = 0;
        occupiedSlot = 0;

        buffer = new Object[BUFFER_MAX];
    }

    @Override
    public void insert(T item) {
        waitUntilFree();
        itemsInBuffer++;
        buffer[freeSlot] = item;
        freeSlot = getNextFreeSlot();
    }

    private void waitUntilFree() {
        while (itemsInBuffer == BUFFER_MAX) {
            Thread.yield(); // prevent thread lockup
        }
    }

    private int getNextFreeSlot() {
        return (freeSlot + 1) % BUFFER_MAX;
    }


    @Override
    public T remove() {
        waitUntilAvailable();
        itemsInBuffer--;
        Object item = buffer[occupiedSlot];
        occupiedSlot = getNextOccupiedSlot();
        return (T) item;
    }

    private void waitUntilAvailable() {
        while (itemsInBuffer == 0) {
            Thread.yield(); // prevent thread lockup
        }
    }

    private int getNextOccupiedSlot() {
        return (occupiedSlot + 1) % BUFFER_MAX;
    }


    @Override
    public String toString() {
        return "BoundedBuffer: itemsInBuffer=" + itemsInBuffer + " freeSlot=" + freeSlot + " occupiedSlot=" + occupiedSlot;
    }
}
