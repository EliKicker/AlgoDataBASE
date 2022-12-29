package Datastructures;

/*
    MIN HEAP
 */

//no avl condition needed as a heap is at every time either an almost complete tree or a complete tree
public class MinHeap<T extends Comparable<T>> {

    Object[] nodes;
    int size;

    //init MinHeap
    //Runtime: O(1)
    public MinHeap(int capacity) {
        nodes = new Object[capacity];
        size = 0;
    }

    //insert element into MinHeap
    //Runtime: O(log n)
    @SuppressWarnings("unchecked")
    public void insert(T element) {
        if (nodes.length > size) {
            nodes[size] = element;
            int i = size;
            while (i != 0 && ((T) nodes[(i - 1) >> 1]).compareTo(element) > 0) {
                swap(i, (i - 1) >> 1);
                i = (i - 1) >> 1;
            }
            size++;
        }
    }

    //extract min element from MinHeap
    //Runtime: O(log n)
    @SuppressWarnings("unchecked")
    public T extractMin() {
        if (isEmpty()) return null;
        T val = (T) nodes[0];
        swap(0, size - 1);
        nodes[size - 1] = null;
        int i = 0;
        while ((i << 1) + 1 <= size - 2) {
            int j = (i << 1) + 1;
            if (j + 1 <= size - 2 && ((T) nodes[j]).compareTo((T) nodes[j + 1]) > 0) j++;
            if (((T) nodes[i]).compareTo((T) nodes[j]) <= 0) break;
            swap(i, j);
            i = j;
        }
        size--;
        return val;
    }

    @SuppressWarnings("unchecked")
    private void swap(int a, int b) {
        T tmp = (T) nodes[a];
        nodes[a] = nodes[b];
        nodes[b] = tmp;
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
        if (isEmpty()) return "[]";
        String s = "[" + nodes[0];
        int i = 1;
        while (i < size) {
            s = s + ", " + nodes[i];
            i++;
        }
        return s + "]";
    }
}
