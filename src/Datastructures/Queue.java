package Datastructures;

/*
    QUEUE DATASTRUCTURE
 */

public class Queue<T> {

    Node<T> first;
    Node<T> last;
    int size;

    //init Queue
    //Runtime: O(1)
    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    //insert element into Queue
    //Runtime: O(1)
    public void insert(T element) {
        if (size == 0) {
            first = new Node<>(element);
            last = first;
        } else {
            last.next = new Node<>(element);
            last = last.next;
        }
        size++;
    }

    //remove element from Queue
    //Runtime: O(1)
    public T remove() {
        if (size == 0) throw new RuntimeException("Cannot remove element from queue as it is empty!");
        T val = first.val;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }
        size--;
        return val;
    }

    //get size of Queue
    //Runtime: O(1)
    public int size() {
        return size;
    }

    //check if Queue is empty
    //Runtime: O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        String s = "[";
        Node<T> n = first;
        s += n.val.toString();
        while (n.next != null) {
            n = n.next;
            s += ", " + n.val.toString();
        }
        return s + "]";
    }

    private class Node<E> {
        E val;
        Node<E> next;

        Node(E val) {
            this.val = val;
        }
    }
}
