package Datastructures;

/*
    BINARY SEARCH TREE
 */

//BST with no duplicates allowed
public class BST<T extends Comparable<T>> {

    Node<T> root;

    public BST() {
        root = null;
    }

    //inserts element into BST (if it is not already contained)
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
        Node<T> node = search(key);
        if (node == null) return;
        if (node.right == null) {
            if (node.left == null) {
                if (node == root) {
                    root = null;
                } else {
                    if (node.parent.left == node) {
                        node.parent.left = null;
                    } else {
                        node.parent.right = null;
                    }
                }
            } else {
                if (node == root) {
                    root = node.left;
                    root.parent = null;
                } else {
                    if (node.parent.left == node) {
                        node.parent.left = node.left;
                    } else {
                        node.parent.right = node.left;
                    }
                    node.left.parent = node.parent;
                }
            }
        } else {
            if (node.left == null) {
                if (node == root) {
                    root = node.right;
                    root.parent = null;
                } else {
                    if (node.parent.left == node) {
                        node.parent.left = node.right;
                    } else {
                        node.parent.right = node.right;
                    }
                    node.right.parent = node.parent;
                }
            } else {
                Node<T> swap = node.left;
                while (swap.right != null) swap = swap.right;
                node.key = swap.key;
                if (swap.left != null) {
                    if (swap.parent.left == swap) {
                        swap.parent.left = swap.left;
                    } else {
                        swap.parent.right = swap.left;
                    }
                    swap.left.parent = swap.parent;
                } else {
                    if (swap.parent.left == swap) {
                        swap.parent.left = null;
                    } else {
                        swap.parent.right = null;
                    }
                }
            }
        }
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
        if (node.key.compareTo(key) > 0) return search(node.left, key);
        return search(node.right, key);
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