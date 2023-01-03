package Algorithms.DP;

/*
    KNAPSACK ALGORITHM
 */

public class Knapsack {

    //knapsack algorithm
    //Runtime: O()
    public static int knapsack(int[] weights, int[] values, int W) {
        int[][] dp = new int[values.length + 1][W + 1];

        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= W; j++) {
                if (j >= weights[i - 1]) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                else dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[values.length][W];
    }
}
