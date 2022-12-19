package util;

/*
    UTILITY FUNCTIONS TO TEST THE GRAPH ALGORITHMS
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MakeGraph {

    //get scanner for input file
    private static Scanner getInputFile(String path) {
        try {
            return new Scanner(new File(path));
        } catch (Exception e) {
            System.out.println("Cannot open file: '" + path + "'");
            return null;
        }
    }

    //return graph in form of an adjacency list
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
}
