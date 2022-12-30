package Datastructures;

/*
    AVL TREE
 */

public class AVLTree<T extends Comparable<T>> {

    Node<T> root;

    public AVLTree() {
        root = null;
    }

    //inserts element into AVLTree (if it is not already contained)
    //Runtime: O(log n)
    public void insert(T key) {

    }

    //deletes element in AVLTree (if it exists)
    //Runtime: O(log n)
    public void delete(T key) {

    }

    //searches for given key in AVLTree
    //Runtime: O(log n)
    public void search(T key) {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Print(sb, root, "", "");
        return sb.toString();
    }

    private void Print(StringBuilder sb, Node<T> node, String prefix, String childrenPrefix) {
        if (node == null) return;
        if (prefix.endsWith("┌──")) {
            Print(sb, node.right, childrenPrefix.substring(0, childrenPrefix.length() - 3) + "   ┌──", childrenPrefix.substring(0, childrenPrefix.length() - 3) + "   │  ");
        } else {
            Print(sb, node.right, childrenPrefix + "┌──", childrenPrefix + "│  ");
        }
        sb.append(prefix);
        sb.append(node.key);
        sb.append("\n");
        if (prefix.endsWith("└──")) {
            Print(sb, node.left, childrenPrefix.substring(0, childrenPrefix.length() - 3) + "   └──", childrenPrefix.substring(0, childrenPrefix.length() - 3) + "   │  ");
        } else {
            Print(sb, node.left, childrenPrefix + "└──", childrenPrefix + "│  ");
        }
    }

    private class Node<E extends Comparable<E>> {

        Node<E> parent;
        Node<E> left;
        Node<E> right;
        E key;

        Node(E key) {
            this.key = key;
        }
    }
}