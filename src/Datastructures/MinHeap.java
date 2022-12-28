package Datastructures;

/*
    MIN HEAP
 */

//no avl condition needed as a heap is at every time either an almost complete tree or a complete tree
public class MinHeap<T> {

    Node<T> head;
    int size;

    //init MinHeap
    //Runtime: O(1)
    public MinHeap() {
        head = null;
        size = 0;
    }

    //insert element into MinHeap
    //Runtime: O(h)
    public void insert(T element) {

    }

    //extract max element from MinHeap
    //Runtime: O(1)
    public T extractMin() {
        return null;
    }

    //get size of MinHeap
    //Runtime: O(1)
    public int size() {
        return size;
    }

    //check if MinHeap is empty
    //Runtime: O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return null;
    }

    private class Node<E> {
        E val;
        Node<E> next;

        Node(E val) {
            this.val = val;
        }
    }
}
