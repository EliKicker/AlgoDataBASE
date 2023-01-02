package Algorithms.GraphAlgorithms;

/*
    KRUSKAL's ALGORITHM
 */

import Datastructures.Graphs.UnionFind;

import java.util.ArrayList;
import java.util.Arrays;

public class Kruskal {

    //kruskal's algorithm
    //Runtime: O(n * log n + m * log m)
    public static ArrayList<Edge> kruskal(ArrayList<ArrayList<Integer>> G, int[][] weight) {
        int m = 0;
        for (int i = 0; i < G.size(); i++) m += G.get(i).size();    //calc number of edges

        //init edge array
        int k = 0;
        Edge[] edges = new Edge[m];
        for (int i = 0; i < G.size(); i++) {
            for (int j : G.get(i)) {
                edges[k++] = new Edge(i, j, weight[i][j]);
            }
        }

        //init mst
        ArrayList<Edge> mst = new ArrayList<>();

        //init UnionFind
        UnionFind ZHKs = new UnionFind(G.size());

        //sort array
        Arrays.sort(edges);

        for (Edge e : edges) {
            if (ZHKs.find(e.node1) == ZHKs.find(e.node2)) continue;
            mst.add(e);
            ZHKs.union(e.node1, e.node2);
        }

        return mst;
    }

    private static class Edge implements Comparable<Edge> {

        int node1;
        int node2;
        int weight;

        Edge(int node1, int node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(o.weight, weight);
        }
    }
}
