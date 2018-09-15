package hadler;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue<T> {

    private Queue<T> queue = new LinkedList<>();

    public void add(T e) {
        queue.add(e);
    }

    public void remove(T e) {
        queue.poll();
    }

    public T get() {
        return queue.peek();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
