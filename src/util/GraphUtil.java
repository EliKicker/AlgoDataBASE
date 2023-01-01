package util;

/*
    UTILITY FUNCTIONS TO TEST THE GRAPH ALGORITHMS
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphUtil {

    static int t;

    //get scanner for input file
    private static Scanner getInputFile(String path) {
        try {
            return new Scanner(new File(path));
        } catch (Exception e) {
            System.out.println("Cannot open file: '" + path + "'");
            return null;
        }
    }

    public static int[][] getAdjListWeighted(String input_path, ArrayList<ArrayList<Integer>> G) {
        Scanner input = getInputFile(input_path);
        if (input != null) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[][] weights = new int[n][n];

            for (int i = 0; i < n; i++) {
                G.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int from = input.nextInt();
                int to = input.nextInt();
                G.get(from).add(to);
                weights[from][to] = input.nextInt();
            }

            return weights;
        }
        return null;
    }

    //return unweighted graph in form of an adjacency list
    public static ArrayList<ArrayList<Integer>> getAdjListUnweighted(String input_path) {
        Scanner input = getInputFile(input_path);
        if (input != null) {
            int n = input.nextInt();                                //number of vertices
            int m = input.nextInt();                                //number of edges
            ArrayList<ArrayList<Integer>> G = new ArrayList<>();    //Graph

            for (int i = 0; i < n; i++) {
                G.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                G.get(input.nextInt()).add(input.nextInt());
            }

            return G;
        }
        return null;
    }

    //detects back/forward/cross/tree edges in graph
    //Runtime: O(n + m)
    public static void classifyEdges(ArrayList<ArrayList<Integer>> G, int x) {
        boolean[] visited = new boolean[G.size()];
        int[] pre = new int[G.size()], post = new int[G.size()];
        t = 1;
        visit(G, x, visited, pre, post);
    }

    private static void visit(ArrayList<ArrayList<Integer>> G, int x, boolean[] visited, int[] pre, int[] post) {
        pre[x] = t++;
        visited[x] = true;
        for (int i : G.get(x)) {
            if (!visited[i]) {
                System.out.println("TREE EDGE: (" + x + ", " + i + ")");
                visit(G, i, visited, pre, post);
            } else {
                if (pre[x] > pre[i]) {
                    if (pre[x] > post[i] && post[i] != 0) {
                        System.out.println("CROSS EDGE: (" + x + ", " + i + ")");
                    } else {
                        System.out.println("BACK EDGE: (" + x + ", " + i + ")");
                    }
                } else {
                    System.out.println("FORWARD EDGE: (" + x + ", " + i + ")");
                }
            }
        }
        post[x] = t++;
    }

    //find a root and return its index if one exists (else return -1)
    //Runtime: O(n + m)
    public static int findRoot(ArrayList<ArrayList<Integer>> G) {
        boolean[] no_root = new boolean[G.size()];
        for (ArrayList<Integer> l : G) {
            for (int i : l) {
                no_root[i] = true;
            }
        }
        for (int i = 0; i < G.size(); i++) {
            if (no_root[i] == false) return i;
        }
        return -1;
    }
}
