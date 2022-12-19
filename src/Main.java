import Algorithms.GraphAlgorithms.*;
import Algorithms.SearchAlgorithms.*;
import Algorithms.SortAlgorithms.*;
import util.MakeArray;
import util.MakeGraph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<ArrayList<Integer>> G = MakeGraph.getAdjListUnweighted("src/util/test_input/UnweightedGraph1");
        DFS.DFS_recursive(G, 0);
        System.out.println();
        DFS.DFS_iterative(G, 0);
        System.out.println();
        BFS.BFS(G, 0);

        int[] A = MakeArray.getArray("src/util/test_input/ArrayDistinctIntegers1");
        System.out.println(Arrays.toString(A));
        int[] B = MakeArray.getArray("src/util/test_input/ArrayWithDuplicates1");
        System.out.println(Arrays.toString(B));
        InsertionSort.insertionSort(A);
        InsertionSort.insertionSort(B);
        System.out.println("\n" + Arrays.toString(A));
        System.out.println(Arrays.toString(B));
    }
}