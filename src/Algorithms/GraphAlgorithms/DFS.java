package Algorithms.GraphAlgorithms;

/*
    DEPTH FIRST SEARCH ALGORITHM
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class DFS {

    //depth first search algorithm with visited array for cyclic graphs (iterative)
    //Runtime: O(n + m)
    public static void DFS_iterative(ArrayList<ArrayList<Integer>> G, int x) {
        LinkedList<Integer> stack = new LinkedList<>();
        boolean[] visited = new boolean[G.size()];
        visited[x] = true;
        stack.push(x);

        while (stack.size() != 0) {
            int v = stack.pop();

            for (int i : G.get(v)) {
                if (!visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
    }

    //depth first search algorithm with visited array for cyclic graphs (recursive)
    //Runtime: O(n + m)
    public static void DFS_recursive(ArrayList<ArrayList<Integer>> G, int x) {
        boolean[] visited = new boolean[G.size()];

        DFS_walk(G, x, visited);
    }

    private static void DFS_walk(ArrayList<ArrayList<Integer>> G, int x, boolean[] visited) {
        visited[x] = true;

        for (int i : G.get(x)) {
            if (!visited[i]) {
                DFS_walk(G, i, visited);
            }
        }
    }
}
