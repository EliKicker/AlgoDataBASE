package Algorithms.GraphAlgorithms;

/*
    DIYKSTRA's ALGORITHM
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {

    //dijkstra's algorithm
    //Runtime: O((n + m) log n)
    public static int[] dijkstra(ArrayList<ArrayList<Integer>> G, int[][] weights, int x) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[G.size()];
        int[] d = new int[G.size()];
        for (int i = 0; i < G.size(); i++) d[i] = 10000000;
        d[x] = 0;
        queue.add(new Node(x, 0));

        while (queue.size() != 0) {
            Node u = queue.poll();
            visited[u.index] = true;

            for (int v : G.get(u.index)) {
                if (!visited[v]) {
                    d[v] = Math.min(d[v], d[u.index] + weights[u.index][v]);
                    queue.add(new Node(v, d[v]));
                }
            }
        }

        return d;
    }

    private static class Node implements Comparable<Node> {

        int index;
        int dist;

        Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(dist, o.dist);
        }
    }
}
