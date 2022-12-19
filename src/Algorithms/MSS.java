package Algorithms;

/*
    MAXIMUM SUBARRAY SUM ALGORITHM
 */

public class MSS {

    public static int MSS(int[] A) {
        int mss = 0;
        int tmp = 0;
        for (int i = 0; i < A.length; i++) {
            if (tmp >= 0) tmp += A[i];
            else tmp = A[i];
            if (tmp > mss) mss = tmp;
        }
        return mss;
    }
}