import Algorithms.GraphAlgorithms.*;
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

        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        int[][] weights = GraphUtil.getAdjListWeighted("src/util/test_input/WeightedGraph4", G);

        System.out.println("\nFLOYD-WARSHALL");
        int[][][] result1 = FloydWarshall.floydWarshall(G, weights);
        for (int i = 0; i < G.size(); i++) {
            System.out.println(Arrays.toString(result1[result1.length - 1][i]));
        }

        System.out.println("\nJOHNSON:");
        int[][] result2 =  Johnson.johnson(G, weights);
        for (int i = 0; i < result2.length; i++) {
            System.out.println(Arrays.toString(result2[i]));
        }
    }
}