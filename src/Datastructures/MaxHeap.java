package Datastructures;

/*
    MAX HEAP
 */

//no avl condition needed as a heap is at every time either an almost complete tree or a complete tree
public class MaxHeap<T> {

    Node<T> head;
    int size;

    //init MaxHeap
    //Runtime: O(1)
    public MaxHeap() {
        head = null;
        size = 0;
    }

    //insert element into MaxHeap
    //Runtime: O(h)
    public void insert(T element) {

    }

    //extract max element from MaxHeap
    //Runtime: O(1)
    public T extractMax() {
        return null;
    }

    //get size of MaxHeap
    //Runtime: O(1)
    public int size() {
        return size;
    }

    //check if MaxHeap is empty
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
