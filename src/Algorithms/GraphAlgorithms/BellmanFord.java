package Algorithms.GraphAlgorithms;

/*
    BELLMAN-FORD ALGORITHM
 */

public class BellmanFord {

    //bellman-ford algorithm
    //Runtime: O(n * m)
    public static int[] bellmanFord(int[] edges1, int[] edges2, int[] edge_weights, int x, int n) {
        int[] d = new int[n];
        for (int i = 0; i < n; i++) d[i] = 10000000;
        d[x] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < edge_weights.length; j++) {
                d[edges2[j]] = Math.min(d[edges2[j]], d[edges1[j]] + edge_weights[j]);
            }
        }

        //test for negative cycles
        for (int j = 0; j < edge_weights.length; j++) {
            if (d[edges1[j]] + edge_weights[j] < d[edges2[j]]) {
                return null;
            }
        }
        return d;
    }
}
