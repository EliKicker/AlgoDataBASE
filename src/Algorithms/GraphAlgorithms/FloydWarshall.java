package Algorithms.GraphAlgorithms;

/*
    FLOYD-WARSHALL ALGORITHM
 */

import java.util.ArrayList;

public class FloydWarshall {

    //floyd-warshall algorithm
    //Runtime: O(n³)
    public static int[][][] floydWarshall(ArrayList<ArrayList<Integer>> G, int[][] weights) {
        //init dp table
        int[][][] dp = new int[G.size() + 1][G.size()][G.size()];
        for (int i = 0; i < G.size(); i++) {
            for (int j = 0; j < G.size(); j++) {
                if (i == j) continue;
                if (G.get(i).contains(j)) {
                    dp[0][i][j] = weights[i][j];
                } else {
                    dp[0][i][j] = 10000000;     //supposed to be infinity
                }
            }
        }

        for (int i = 1; i < G.size() + 1; i++) {
            for (int j = 0; j < G.size(); j++) {
                for (int k = 0; k < G.size(); k++) {
                    dp[i][j][k] = Math.min(dp[i - 1][j][k], dp[i - 1][j][i - 1] + dp[i - 1][i - 1][k]);
                }
            }
        }

        return dp;
    }
}
