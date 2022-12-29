package Datastructures;

/*
    BINARY SEARCH TREE
 */

public class BST<T extends Comparable<T>> {

    Node<T> root;
    int size;

    public BST() {
        root = null;
        size = 0;
    }

    //inserts element into BST
    //Runtime: O(n)
    public void insert(T key) {
        if (root == null) {
            root = new Node<>(key);
        } else {
            insert(root, key);
        }
    }

    private void insert(Node<T> node, T key) {
        if (node.key.compareTo(key) > 0) {
            if (node.left != null) {
                insert(node.left, key);
            } else {
                node.left = new Node<>(key);
                node.left.parent = node;
            }
        } else if (node.key.compareTo(key) < 0) {
            if (node.right != null) {
                insert(node.right, key);
            } else {
                node.right = new Node<>(key);
                node.right.parent = node;
            }
        }
    }

    //deletes element in BST (if it exists)
    //Runtime: O(n)
    public void delete(T key) {

    }

    //searches for given key in BST
    //Runtime: O(n)
    private Node<T> search(T key) {
        if (root == null) return null;
        return search(root, key);
    }

    private Node<T> search(Node<T> node, T key) {
        if (node == null) return null;
        if (node.key.compareTo(key) == 0) return node;
        if (node.key.compareTo(key) > 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    @Override
    public String toString() {
        if (root == null) return "";
        StringBuilder buffer = new StringBuilder();
        root.print(buffer, "", "");
        return buffer.toString();
    }

    private class Node<E extends Comparable<E>> {

        Node<E> parent;
        Node<E> left;
        Node<E> right;
        E key;

        Node(E key) {
            this.key = key;
        }

        void print(StringBuilder buffer, String prefix, String childrenPrefix) {
            buffer.append(prefix);
            buffer.append(key.toString());
            buffer.append("\n");
            if (right != null) {
                if (left != null) {
                    right.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
                    left.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
                } else {
                    right.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
                }
            } else {
                if (left != null) {
                    left.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
                }
            }
        }
    }
}