package Algorithms.SearchAlgorithms;

/*
    BINARY SEARCH ALGORITHM
 */

public class BinarySearch {

    //recursive binary search
    //Runtime: O(log n)
    public static int binarySearch_recursive(int[] A, int l, int r, int x) {
        if (l > r) return -1;
        int m = l + ((r - l) >> 1);
        if (A[m] == x) return m;
        if (A[m] > x) {
            return binarySearch_recursive(A, l, m - 1, x);
        } else {
            return binarySearch_recursive(A, m + 1, r, x);
        }
    }

    //iterative binary search
    //Runtime: O(log n)
    public static int binarySearch_iterative(int[] A, int x) {
        int l = 0;
        int r = A.length - 1;

        while (l <= r) {
            int m = l + ((r - l) / 2);
            if (A[m] == x) return m;
            if (A[m] > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    //also works with absolute order relation
    /*public static int binarySearch_iterative(int[] A, int x) {
        int l = 0;
        int r = A.length - 1;

        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (A[m] == x) return m;
            if (A[m] > x) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }*/
}
