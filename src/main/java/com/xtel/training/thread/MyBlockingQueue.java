package com.xtel.training.thread;

public class MyBlockingQueue<E> {

    private final Object doPut = new Object();

    private final Object doTake = new Object();

    private int size;

    private int capacity;

    private Node<E> first, last;

    public MyBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    public MyBlockingQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
    }

    public E take() throws InterruptedException {
        E obj;

        synchronized (doTake) {
            if (isEmpty())
                doTake.wait();
            obj = unlinkFirst(first);
        }

        synchronized (doPut) {
            doPut.notifyAll();
        }

        return obj;
    }

    public void put(E data) throws InterruptedException {
        Node newNode = new Node(data);

        synchronized (doPut) {
            if (size == capacity)
                doPut.wait();

            if (first == null || last == null) {
                first = last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }

            size++;
        }

        synchronized (doTake) {
            doTake.notifyAll();
        }
    }

    private E unlinkFirst(Node<E> fNode) {
        if (fNode == null)
            return null;

        final E data = fNode.data;
        final Node<E> next = fNode.next;

        fNode.data = null;
        fNode.next = null;

        first = next;

        if (next == null)
            last = null;

        size--;
        return data;
    }

    public synchronized void upsize(int num) {
        size += num;
    }

    public synchronized int size() {
        return size;
    }

    public synchronized int getCapacity() {
        return capacity;
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    public synchronized boolean isFull() {
        return size == capacity;
    }

    static class Node<T> {

        public T data;

        public Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node() {
        }
    }
}
