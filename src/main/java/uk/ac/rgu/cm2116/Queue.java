package uk.ac.rgu.cm2116;

public class Queue<T> extends SoCQueue<T> {

    private Object[] queue;
    private int front;
    private int rear;
    private int size;

    public Queue() {
        this.queue = new Object[5];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(T e) throws IllegalStateException {
        int index = rear % this.queue.length;
        if (front == index && this.size != 0) {
            throw new IllegalStateException();
        }
        this.queue[index] = e;
        rear++;
        size++;
        return true;
    }

    @Override
    public boolean offer(T e) {
        int index = rear % this.queue.length;
        if (front == index && this.size != 0) {
            return false;
        }
        this.queue[index] = e;
        rear++;
        size++;
        return true;
    }

    @Override
    public T remove() {
        if (size == 0) {
            return null;
        }

        T element = (T) this.queue[front % this.queue.length];
        front++;
        size--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }

}
