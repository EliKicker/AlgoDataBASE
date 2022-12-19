package Algorithms.GraphAlgorithms;

/*
    BREADTH FIRST SEARCH ALGORITHM
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {

    //breadth first search algorithm with visited array for cyclic graphs
    //Runtime: O(n + m)
    public static void BFS(ArrayList<ArrayList<Integer>> G, int x) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[G.size()];
        visited[x] = true;
        queue.add(x);

        while (queue.size() != 0) {
            int v = queue.poll();

            for (int i : G.get(v)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
