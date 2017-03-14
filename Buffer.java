/**
 * Created by thoma on 13-Mar-17.
 */
public interface Buffer<T> {
    public abstract void insert(T item);

    public abstract T remove();
}
