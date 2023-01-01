package Algorithms.GraphAlgorithms;

/*
    TOPOLOGICAL SORT ALGORITHM
 */

import util.GraphUtil;

import java.util.ArrayList;
import java.util.LinkedList;

public class TopoSort {

    static int t;
    static LinkedList<Integer> postOrderedSorting;

    //topological sort (reverse post order) (recursive)
    //Runtime: O(n + m)
    public static Integer[] topoSort(ArrayList<ArrayList<Integer>> G) {
        int x = GraphUtil.findRoot(G);
        if (x == -1) return null;
        boolean[] visited = new boolean[G.size()];
        int[] pre = new int[G.size()], post = new int[G.size()];
        t = 1;
        postOrderedSorting = new LinkedList<>();
        if (visit(G, x, visited, pre, post) == false) return null;
        return postOrderedSorting.toArray(new Integer[postOrderedSorting.size()]);
    }

    private static boolean visit(ArrayList<ArrayList<Integer>> G, int x, boolean[] visited, int[] pre, int[] post) {
        pre[x] = t++;
        visited[x] = true;
        boolean acyclic = true;
        for (int i : G.get(x)) {
            if (!visited[i]) {
                acyclic = acyclic && visit(G, i, visited, pre, post);
            } else if (pre[x] > pre[i] && (pre[x] < post[i] || post[i] == 0)) {
                acyclic = false;
            }
        }
        post[x] = t++;
        postOrderedSorting.push(x);
        return acyclic;
    }
}
