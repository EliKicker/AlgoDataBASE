package Datastructures;

/*
    PRIORITY QUEUE DATASTRUCTURE
 */

public class PriorityQueue<T extends Comparable<T>> {

    MinHeap<T> queue;

    PriorityQueue(int capacity) {
        queue = new MinHeap<>(capacity);
    }

    public void insert(T element) {
        queue.insert(element);
    }

    public T extractMin() {
        return queue.extractMin();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public String toString() {
        return queue.toString();
    }
}
