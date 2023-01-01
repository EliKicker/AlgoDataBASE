import Algorithms.GraphAlgorithms.BellmanFord;
import Algorithms.GraphAlgorithms.Dijkstra;
import Algorithms.GraphAlgorithms.TopoSort;
import util.ArrayUtil;
import util.GraphUtil;

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

        int[] A = ArrayUtil.getArray("src/util/test_input/ArrayDistinctIntegers1");
        System.out.println(Arrays.toString(A));
        int[] B = ArrayUtil.getArray("src/util/test_input/ArrayWithDuplicates1");
        System.out.println(Arrays.toString(B));
        //QuickSort.quickSort(A, 0, A.length - 1);
        //QuickSort.quickSort(B, 0, B.length - 1);
        System.out.println("\n" + Arrays.toString(A));
        System.out.println(Arrays.toString(B));

        //ArrayList<ArrayList<Integer>> G = GraphUtil.getAdjListUnweighted("src/util/test_input/AcyclicUnweightedGraph1");
        //System.out.println(Arrays.toString(TopoSort.topoSort(G)));

        int[] edges1 = new int[10];
        int[] edges2 = new int[10];
        int[] edge_weights = new int[10];
        int n = 7;
        GraphUtil.getEdgeArrayWeighted("src/util/test_input/WeightedGraph1", edges1, edges2, edge_weights);
        System.out.println(Arrays.toString(BellmanFord.bellmanFord(edges1, edges2, edge_weights, 0, n)));
    }
}