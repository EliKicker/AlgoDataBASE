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
            System.out.println("v: " + v);
            for (int i : G.get(v)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    //breath first search with array as queue
    //Runtime: O(n + m)
    public static void BFS_array(ArrayList<ArrayList<Integer>> G, int x) {
        int[] queue = new int[G.size()];
        boolean[] visited = new boolean[G.size()];
        int l = 0;
        int r = 1;
        visited[x] = true;
        queue[l] = x;

        while (l < r) {
            x = queue[l++];
            System.out.println("x: " + x);
            for (int i : G.get(x)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue[r++] = i;
                }
            }
        }
    }
}
