package Datastructures;

/*
    STACK DATASTRUCTURE
 */

public class Stack<T> {

    Node<T> first;
    int size;

    public Stack() {
        first = null;
        size = 0;
    }

    public void push(T element) {
        first = new Node<>(element, first);
        size++;
    }

    public T pop() {
        if (size == 0) throw new RuntimeException("Cannot pop element from stack as it is empty!");
        T val = first.val;
        first = first.next;
        size--;
        return val;
    }

    public T peek() {
        if (size == 0) throw new RuntimeException("Cannot peek element from stack as it is empty!");
        return first.val;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        String s = "]";
        Node<T> n = first;
        s = n.val.toString() + s;
        while (n.next != null) {
            n = n.next;
            s = n.val.toString() + ", " + s;
        }
        return "[" + s;
    }
    private class Node<E> {
        E val;
        Node<E> next;

        Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }
}
