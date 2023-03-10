package Datastructures;

/*
    AVL TREE
 */

//avl tree with no duplicated allowed
public class AVLTree<T extends Comparable<T>> {

    Node<T> root;

    public AVLTree() {
        root = null;
    }

    //inserts element into AVLTree (if it is not already contained)
    //Runtime: O(log n)
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
        updateHeight(node);
        rebalance(node);
    }

    //deletes element in AVLTree (if it exists)
    //Runtime: O(log n)
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
            while (node.parent != null) {
                node = node.parent;
                updateHeight(node);
                rebalance(node);
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
                while (node.parent != null) {
                    node = node.parent;
                    updateHeight(node);
                    rebalance(node);
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
                while (swap.parent != null) {
                    swap = swap.parent;
                    updateHeight(swap);
                    rebalance(swap);
                }
            }
        }
    }

    private int height(Node<T> node) {
        return (node == null) ? -1 : node.height;
    }

    private void updateHeight(Node<T> node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    //searches for given key in AVLTree
    //Runtime: O(log n)
    private Node<T> search(T key) {
        return search(root, key);
    }

    private Node<T> search(Node<T> node, T key) {
        if (node == null) return null;
        if (node.key.compareTo(key) == 0) return node;
        if (node.key.compareTo(key) > 0) return search(node.left, key);
        return search(node.right, key);
    }

    private void rebalance(Node<T> node) {
        int bal = height(node.right) - height(node.left);
        if (bal < -1) {
            if (height(node.left.right) - height(node.left.left) > 0) {
                rotateLeft(node.left);
            }
            if (root == node) {
                root = rotateRight(node);
            } else {
                rotateRight(node);
            }
        }
        if (bal > 1) {
            if (height(node.right.right) - height(node.right.left) < 0) {
                rotateRight(node.right);
            }
            if (root == node) {
                root = rotateLeft(node);
            } else {
                rotateLeft(node);
            }
        }
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> tmp = node.left;
        node.left = tmp.right;
        if (tmp.right != null) tmp.right.parent = node;
        tmp.right = node;
        return updateParents(node, tmp);
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> tmp = node.right;
        node.right = tmp.left;
        if (tmp.left != null) tmp.left.parent = node;
        tmp.left = node;
        return updateParents(node, tmp);
    }

    private Node<T> updateParents(Node<T> node, Node<T> tmp) {
        tmp.parent = node.parent;
        if (node.parent != null) {
            if (node == node.parent.left) node.parent.left = tmp;
            else node.parent.right = tmp;
        }
        node.parent = tmp;
        updateHeight(node);
        updateHeight(tmp);
        return tmp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Print(sb, root, "", "");
        return sb.toString();
    }

    private void Print(StringBuilder sb, Node<T> node, String prefix, String childrenPrefix) {
        if (node == null) return;
        if (prefix.endsWith("?????????")) {
            Print(sb, node.right, childrenPrefix.substring(0, childrenPrefix.length() - 3) + "   ?????????", childrenPrefix.substring(0, childrenPrefix.length() - 3) + "   ???  ");
        } else {
            Print(sb, node.right, childrenPrefix + "?????????", childrenPrefix + "???  ");
        }
        sb.append(prefix);
        sb.append(node.key + ":" + node.height);
        sb.append("\n");
        if (prefix.endsWith("?????????")) {
            Print(sb, node.left, childrenPrefix.substring(0, childrenPrefix.length() - 3) + "   ?????????", childrenPrefix.substring(0, childrenPrefix.length() - 3) + "   ???  ");
        } else {
            Print(sb, node.left, childrenPrefix + "?????????", childrenPrefix + "???  ");
        }
    }

    private class Node<E extends Comparable<E>> {

        Node<E> parent;
        Node<E> left;
        Node<E> right;
        E key;
        int height;

        Node(E key) {
            this.key = key;
        }
    }
}