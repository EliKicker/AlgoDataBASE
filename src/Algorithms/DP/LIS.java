package Algorithms.DP;

/*
    LONGEST INCREASING SUBSEQUENCE ALGORITHM
 */

import java.util.Arrays;

public class LIS {

    //longest increasing subsequence algorithm
    //Runtime: O(n * log n)
    public static int[] lis(int[] A) {
        int[] M = new int[A.length + 1];
        int[] P = new int[A.length];
        int len = 0;

        for (int i = 0; i < A.length; i++) {
            int l = 1;
            int r = len + 1;

            while (l < r) {
                int m = l + ((r - l) >> 1);
                if (A[M[m]] > A[i]) {           //if we use >= instead of > we have a strictly increasing subsequence
                    r = m;
                } else {
                    l = m + 1;
                }
            }

            P[i] = M[l - 1];
            M[l] = i;
            if (l > len) len = l;
        }

        //reconstruct lis
        int[] lis = new int[len];
        int k = M[len];
        for (int i = len - 1; i >= 0; i--) {
            lis[i] = A[k];
            k = P[k];
        }

        return lis;
    }
}
