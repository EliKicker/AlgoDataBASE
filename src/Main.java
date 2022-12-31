import Algorithms.GraphAlgorithms.*;
import Algorithms.*;
import Algorithms.SearchAlgorithms.*;
import Algorithms.SortAlgorithms.*;
import Datastructures.*;
import Datastructures.Graphs.UnionFind;
import util.MakeArray;
import util.MakeGraph;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /*ArrayList<ArrayList<Integer>> G = MakeGraph.getAdjListUnweighted("src/util/test_input/UnweightedGraph1");
        DFS.DFS_recursive(G, 0);
        System.out.println();
        DFS.DFS_iterative(G, 0);
        System.out.println();
        BFS.BFS(G, 0);*/

        int[] A = MakeArray.getArray("src/util/test_input/ArrayDistinctIntegers1");
        System.out.println(Arrays.toString(A));
        int[] B = MakeArray.getArray("src/util/test_input/ArrayWithDuplicates1");
        System.out.println(Arrays.toString(B));
        //QuickSort.quickSort(A, 0, A.length - 1);
        //QuickSort.quickSort(B, 0, B.length - 1);
        System.out.println("\n" + Arrays.toString(A));
        System.out.println(Arrays.toString(B));

        AVLTree<Integer> avl = new AVLTree<>();

        avl.insert(50);
        System.out.println(avl);
        avl.insert(10);
        System.out.println(avl);
        avl.insert(60);
        System.out.println(avl);
        avl.insert(30);
        System.out.println(avl);
        avl.insert(40);
        System.out.println(avl);
        avl.insert(55);
        System.out.println(avl);
        avl.insert(80);
        System.out.println(avl);
        avl.insert(20);
        System.out.println(avl);
        avl.insert(12);
        System.out.println(avl);
        avl.insert(11);
        System.out.println(avl);
        avl.insert(9);
        System.out.println(avl);
        System.out.println("insert 42");
        avl.insert(42);
        System.out.println(avl);
        System.out.println("delete 40");
        avl.delete(40);
        System.out.println(avl);
    }
}