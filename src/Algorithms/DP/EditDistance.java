package Algorithms.DP;

/*
    EDIT DISTANCE ALGORITHM
 */

public class EditDistance {

    //edit distance algorithm with 3 ops
    //  1. change letter
    //  2. insert letter
    //  3. delete letter
    //Runtime: O(mn)
    public static int editDistance(char[] A, char[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = 0; i <= A.length; i++) dp[i][0] = i;
        for (int j = 0; j <= B.length; j++) dp[0][j] = j;

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }

        return dp[A.length][B.length];
    }
}
