package Algorithms.GraphAlgorithms;

/*
    PRIM's ALGORITHM
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prim {

    //prims algorithm (treats graph as directed graph because laziness of me)
    //Runtime: O((n + m) log n)
    public static ArrayList<ArrayList<Integer>> prim(ArrayList<ArrayList<Integer>> G, int[][] weights, int x) {
        ArrayList<ArrayList<Integer>> mst = new ArrayList<>();
        for (int i = 0; i < G.size(); i++) mst.add(new ArrayList<>());
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[G.size()];
        int[] d = new int[G.size()];
        for (int i = 0; i < G.size(); i++) d[i] = ~0 >>> 1;
        d[x] = 0;
        queue.add(new Node(x, x, 0));

        while (queue.size() != 0) {
            Node u = queue.poll();
            if (visited[u.index]) continue;
            visited[u.index] = true;
            mst.get(u.predecessor).add(u.index);
            System.out.println(u);

            for (int v : G.get(u.index)) {
                if (!visited[v]) {
                    d[v] = Math.min(d[v], weights[u.index][v]);
                    queue.add(new Node(u.index, v, d[v]));
                }
            }
        }

        return mst;
    }

    private static class Node implements Comparable<Node> {

        int predecessor;
        int index;
        int dist;

        Node(int predecessor, int index, int dist) {
            this.predecessor = predecessor;
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(dist, o.dist);
        }

        @Override
        public String toString() {
            return predecessor + " -> " + index;
        }
    }
}
