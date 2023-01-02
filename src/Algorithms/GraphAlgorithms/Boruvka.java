package Algorithms.GraphAlgorithms;

/*
    BORUVKA's ALGORITHM
 */

import Datastructures.Graphs.UnionFind;

import java.util.ArrayList;
import java.util.Arrays;

public class Boruvka {

    //boruvka's algorithm
    //Runtime: O((n + m) log n)
    public static ArrayList<Edge> boruvka(ArrayList<ArrayList<Integer>> G, int[][] weights) {
        int m = 0;
        for (int i = 0; i < G.size(); i++) m += G.get(i).size();    //calc number of edges

        //init edge array
        Edge[] edges = new Edge[m];
        int k = 0;
        for (int i = 0; i < G.size(); i++) {
            for (int j : G.get(i)) {
                edges[k++] = new Edge(i, j, weights[i][j]);
            }
        }

        int n_ZHKs = G.size();
        Edge[] cheapest = new Edge[n_ZHKs];
        UnionFind ZHKs = new UnionFind(n_ZHKs);
        ArrayList<Edge> mst = new ArrayList<>();

        while (n_ZHKs > 1) {
            for (Edge e : edges) {
                if (ZHKs.find(e.node1) == ZHKs.find(e.node2)) continue;
                if (cheapest[ZHKs.find(e.node1)] == null || e.weight < cheapest[ZHKs.find(e.node1)].weight) cheapest[ZHKs.find(e.node1)] = e;
                if (cheapest[ZHKs.find(e.node2)] == null || e.weight < cheapest[ZHKs.find(e.node2)].weight) cheapest[ZHKs.find(e.node2)] = e;
            }

            for (int i = 0; i < cheapest.length; i++) {
                if (cheapest[i] != null && ZHKs.find(cheapest[i].node1) != ZHKs.find(cheapest[i].node2)) {
                    System.out.println("unify " + cheapest[i]);
                    ZHKs.union(cheapest[i].node1, cheapest[i].node2);
                    mst.add(cheapest[i]);
                    n_ZHKs--;
                }
                cheapest[i] = null;
            }
        }

        return mst;
    }

    private static class Edge {

        int node1;
        int node2;
        int weight;

        Edge(int node1, int node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return node1 + " -> " + node2 + " w: " + weight;
        }
    }
}
