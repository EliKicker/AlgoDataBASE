package Algorithms.GraphAlgorithms;

/*
    JOHNSON's ALGORITHM
 */

import java.util.ArrayList;

public class Johnson {

    //johnson's algorithm
    //Runtime: O(mn * log n + n² * log n)
    public static int[][] johnson(ArrayList<ArrayList<Integer>> G, int[][] weights) {
        int[][] distances = new int[G.size()][G.size()];

        //add new node
        int m = 0;
        for (int i = 0; i < G.size(); i++) m += G.get(i).size();
        int[] edges1 = new int[m + G.size()];
        int[] edges2 = new int[m + G.size()];
        int[] edge_weights = new int[m + G.size()];
        int k = 0;
        for (int i = 0; i < G.size(); i++) {
            for (int j : G.get(i)) {
                edges1[k] = i;
                edges2[k] = j;
                edge_weights[k++] = weights[i][j];
            }
        }
        for (int i = 0; i < G.size(); i++) {
            edges1[k] = G.size();
            edges2[k++] = i;
        }

        //bellman-ford on the new node
        int[] h = BellmanFord.bellmanFord(edges1, edges2, edge_weights, G.size(), G.size() + 1);
        if (h == null) return null;

        //init new edge_weights
        int[][] new_weights = new int[weights.length][weights.length];
        for (int i = 0; i < G.size(); i++) {
            for (int j : G.get(i)) {
                new_weights[i][j] = weights[i][j] + h[i] - h[j];
            }
        }

        //n times dijkstra
        for (int i = 0; i < G.size(); i++) {
            distances[i] = Dijkstra.dijkstra(G, new_weights, i);
        }

        //correct distances
        //just for comparison with floyd-warshall
        for (int i = 0; i < G.size(); i++) {
            for (int j : G.get(i)) {
                distances[i][j] = distances[i][j] + h[j] - h[i];
            }
        }

        return distances;
    }
}
