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
    }
}