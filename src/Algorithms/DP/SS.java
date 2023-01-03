package Algorithms.DP;

/*
    SUBSET SUM ALGORITHM
 */

public class SS {

    //subset sum algorithm
    //Runtime: O(bn)
    public static boolean subsetSum(int[] A, int b) {
        boolean[][] dp = new boolean[A.length + 1][b + 1];

        for (int i = 0; i <= A.length; i++) dp[i][0] = true;

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= b; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1]) dp[i][j] = dp[i][j] || dp[i - 1][j - A[i - 1]];
            }
        }

        return dp[A.length][b];
    }
}
